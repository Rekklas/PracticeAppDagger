package com.rekklesdroid.practiceappdagger.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.rekklesdroid.practiceappdagger.R
import com.rekklesdroid.practiceappdagger.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity(), View.OnClickListener {

    @Inject lateinit var providerFactory: ViewModelProviderFactory

    @Inject lateinit var logo: Drawable
    @Inject lateinit var requestManager: RequestManager
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        login_button.setOnClickListener(this)

        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        setLogo()

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.observeUser().observe(this, Observer {
            Log.d(TAG, "subscribeObservers: " + it.email)
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }



    private fun setLogo() {
        requestManager.load(logo)
            .into(login_logo)
    }

    override fun onClick(v: View?) {
        v?.let {
            when(v.id) {
                R.id.login_button -> {
                    attemptLogin()
                }
            }
        }
    }

    private fun attemptLogin() {
        user_id_input.text.toString().let { userId ->
            if (TextUtils.isEmpty(userId)) return
            viewModel.authenticateWithId(Integer.parseInt(userId))
        }
    }

    companion object {
        private const val TAG = "AuthActivity"
    }
}