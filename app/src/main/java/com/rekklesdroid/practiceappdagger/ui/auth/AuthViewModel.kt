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

    private val authUser: MediatorLiveData<AuthResource<User>> = MediatorLiveData()

    fun authenticateWithId(id: Int) {
        authUser.value = AuthResource.Loading(null)

        val source = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(id)
                .onErrorReturn {
                    User(-1)
                }
                .map {
                    if (it.id == -1)
                        return@map AuthResource.Error("Couldn't authenticate. \n Did you enter number from 1 to 10?", it)
                    else
                        return@map AuthResource.Authenticated(it)
                }
                .subscribeOn(Schedulers.io())
        )

        with(authUser) {
            addSource(source) { user ->
                value = user
                removeSource(source)
            }
        }
    }

    fun observeUser(): LiveData<AuthResource<User>> {
        return authUser
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}