package com.rekklesdroid.practiceappdagger.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.rekklesdroid.practiceappdagger.network.AuthApi
import javax.inject.Inject

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    init {
        Log.d(TAG, "AuthApi: $authApi")
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}