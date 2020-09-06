package com.rekklesdroid.practiceappdagger.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.rekklesdroid.practiceappdagger.SessionManager
import com.rekklesdroid.practiceappdagger.models.User
import com.rekklesdroid.practiceappdagger.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
class AuthViewModel @Inject constructor(private val authApi: AuthApi,
                                        private val sessionManager: SessionManager) : ViewModel() {

    fun authenticateWithId(id: Int) {
        Log.d(TAG, "authenticateWithId: trying to login")
        sessionManager.authenticateWithId(queryUserId(id))
    }

    private fun queryUserId(id: Int): LiveData<AuthResource<User>> {
        return LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(id)
                .onErrorReturn {
                    User(-1)
                }
                .map {
                    if (it.id == -1)
                        return@map AuthResource.Error(
                            "Couldn't authenticate. \n Did you enter number from 1 to 10?",
                            it
                        )
                    else
                        return@map AuthResource.Authenticated(it)
                }
                .subscribeOn(Schedulers.io())
        )
    }

    fun observeUser(): LiveData<AuthResource<User>> {
        return sessionManager.getAuthUser()
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}