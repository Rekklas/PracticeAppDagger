package com.rekklesdroid.practiceappdagger

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.rekklesdroid.practiceappdagger.models.User
import com.rekklesdroid.practiceappdagger.ui.auth.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created on 9/6/2020 by eduard.kovalchuk
 */
@Singleton
class SessionManager @Inject constructor() {

    private val cachedUser: MediatorLiveData<AuthResource<User>> = MediatorLiveData()

    fun authenticateWithId(source: LiveData<AuthResource<User>>) {
        cachedUser.value = AuthResource.Loading(null)
        cachedUser.addSource(source) {
            cachedUser.value = it
            cachedUser.removeSource(source)
        }
    }

    fun logout() {
        Log.d(TAG, "logout: ")
        cachedUser.value = AuthResource.NotAuthenticated()
    }

    fun getAuthUser(): LiveData<AuthResource<User>> {
        return cachedUser
    }

    companion object {
        private const val TAG = "SessionManager"
    }
}