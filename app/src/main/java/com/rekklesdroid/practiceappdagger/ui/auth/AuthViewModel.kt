package com.rekklesdroid.practiceappdagger.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
class AuthViewModel @Inject constructor() : ViewModel() {

    init {
        Log.d(TAG, "constructor invoke: ")
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}