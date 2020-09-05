package com.rekklesdroid.practiceappdagger.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.rekklesdroid.practiceappdagger.R
import com.rekklesdroid.practiceappdagger.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    companion object {
        private const val TAG = "AuthActivity"
    }

    @Inject lateinit var providerFactory: ViewModelProviderFactory

    @Inject lateinit var logo: Drawable
    @Inject lateinit var requestManager: RequestManager
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        setLogo()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }



    private fun setLogo() {
        requestManager.load(logo)
            .into(login_logo)
    }
}