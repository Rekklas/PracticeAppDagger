package com.rekklesdroid.practiceappdagger.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
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
            when(it) {
                is AuthResource.Authenticated -> {
                    showProgressBar(false)
                    Log.d(TAG, "subscribeObservers: LOGIN SUCCESS - " + it.data?.email)
                }
                is AuthResource.Loading -> {
                    showProgressBar(true)
                }
                is AuthResource.Error -> {
                    showProgressBar(false)
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is AuthResource.NotAuthenticated -> {
                    showProgressBar(false)
                }
            }
        })
    }
    
    private fun showProgressBar(isVisible: Boolean) {
        progress_bar.visibility = if (isVisible) View.VISIBLE else View.GONE
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
            if (!TextUtils.isDigitsOnly(userId)) return
            viewModel.authenticateWithId(Integer.parseInt(userId))
        }
    }

    companion object {
        private const val TAG = "AuthActivity"
    }
}