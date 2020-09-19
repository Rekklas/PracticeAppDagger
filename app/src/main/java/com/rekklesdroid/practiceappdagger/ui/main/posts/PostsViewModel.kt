package com.rekklesdroid.practiceappdagger.ui.main.posts

import android.util.Log
import androidx.lifecycle.*
import com.rekklesdroid.practiceappdagger.SessionManager
import com.rekklesdroid.practiceappdagger.models.Post
import com.rekklesdroid.practiceappdagger.network.main.MainApi
import com.rekklesdroid.practiceappdagger.utils.Resource
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created on 9/19/2020 by eduard.kovalchuk
 */
class PostsViewModel @Inject constructor(
    val sessionManager: SessionManager, private val mainApi: MainApi
) : ViewModel() {

    private val posts = MediatorLiveData<Resource<List<Post>>>()

    init {
        Log.d(TAG, "PostsViewModel is working")
    }

    fun observePosts(): LiveData<Resource<List<Post>>> {
        posts.value = Resource.Loading()
        val userId = sessionManager.getAuthUser().value?.data?.id
        if (userId == null) posts.value = Resource.Error("Error: userId is null", null)

        val source = LiveDataReactiveStreams.fromPublisher(
            mainApi.getPostsFromUser(userId!!)
                .onErrorReturn {
                    Log.e(TAG, "observePosts: ${it.message}", it)
                    mutableListOf(Post(userId, -1))
                }
                .map {
                    if (it.isNotEmpty()) {
                        if (it[0].id == -1) {
                            Resource.Error("Something went wrong", null)
                        }
                    }
                    Resource.Success(it)
                }
                .subscribeOn(Schedulers.io())
        )
        posts.addSource(source, Observer {
            posts.value = it
            posts.removeSource(source)
        })
        return posts
    }

    companion object {
        private const val TAG = "PostsViewModel"
    }
}