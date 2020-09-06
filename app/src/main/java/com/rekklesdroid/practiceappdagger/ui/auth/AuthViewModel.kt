package com.rekklesdroid.practiceappdagger.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.rekklesdroid.practiceappdagger.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    init {
        authApi.getUser(1)
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d(TAG, "onNext: ${it.email}")
            }, {
                Log.e(TAG, "onError: ", it)
            })
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}