package com.rekklesdroid.practiceappdagger.ui.main.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rekklesdroid.practiceappdagger.SessionManager
import com.rekklesdroid.practiceappdagger.models.User
import com.rekklesdroid.practiceappdagger.ui.auth.AuthResource
import javax.inject.Inject

/**
 * Created on 9/7/2020 by eduard.kovalchuk
 */
class ProfileViewModel @Inject constructor(private val sessionManager: SessionManager): ViewModel() {

    init {
        Log.d(TAG, "ProfileViewModel: is working")
    }

    fun getAuthenticatedUser(): LiveData<AuthResource<User>> {
        return sessionManager.getAuthUser()
    }

    companion object {
        private const val TAG = "ProfileViewModel"
    }
}