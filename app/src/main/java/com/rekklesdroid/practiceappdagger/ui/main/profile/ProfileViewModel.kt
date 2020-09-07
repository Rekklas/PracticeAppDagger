package com.rekklesdroid.practiceappdagger.ui.main.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created on 9/7/2020 by eduard.kovalchuk
 */
class ProfileViewModel @Inject constructor(): ViewModel() {

    init {
        Log.d(TAG, "ProfileViewModel: is working")
    }

    companion object {
        private const val TAG = "ProfileViewModel"
    }
}