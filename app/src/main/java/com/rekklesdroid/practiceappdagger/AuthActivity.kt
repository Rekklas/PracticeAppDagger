package com.rekklesdroid.practiceappdagger

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    companion object {
        private const val TAG = "AuthActivity"
    }

    @Inject lateinit var logo: Drawable
    @Inject lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

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