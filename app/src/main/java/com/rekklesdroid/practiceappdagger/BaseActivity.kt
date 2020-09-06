package com.rekklesdroid.practiceappdagger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.rekklesdroid.practiceappdagger.ui.auth.AuthActivity
import com.rekklesdroid.practiceappdagger.ui.auth.AuthResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created on 9/7/2020 by eduard.kovalchuk
 */
abstract class BaseActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        sessionManager.getAuthUser().observe(this, Observer {
            when(it) {
                is AuthResource.Authenticated -> {
                    Log.d(TAG, "subscribeObservers: LOGIN SUCCESS - " + it.data?.email)
                }
                is AuthResource.Loading -> {
                }
                is AuthResource.Error -> {
                    Log.e(TAG, "subscribeObservers: ${it.message}")
                }
                is AuthResource.NotAuthenticated -> {
                    navLoginScreen()
                }
            }
        })
    }

    private fun navLoginScreen() {
        Log.d(TAG, "navLoginScreen: ")
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    companion object {
        private const val TAG = "BaseActivity"
    }
}