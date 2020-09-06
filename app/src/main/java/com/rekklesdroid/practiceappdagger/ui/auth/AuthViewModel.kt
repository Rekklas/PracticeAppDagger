package com.rekklesdroid.practiceappdagger.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.rekklesdroid.practiceappdagger.models.User
import com.rekklesdroid.practiceappdagger.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    private val authUser: MediatorLiveData<User> = MediatorLiveData()

    fun authenticateWithId(id: Int) {
        val source = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(id).subscribeOn(Schedulers.io())
        )

        with(authUser) {
            addSource(source) { user ->
                value = user
                removeSource(source)
            }
        }
    }

    fun observeUser(): LiveData<User> {
        return authUser
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}