package com.rekklesdroid.practiceappdagger.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.rekklesdroid.practiceappdagger.R
import com.rekklesdroid.practiceappdagger.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created on 9/7/2020 by eduard.kovalchuk
 */
class ProfileFragment : DaggerFragment() {

    @Inject lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated: Profile fragment was created")

        viewModel = ViewModelProvider(this, providerFactory).get(ProfileViewModel::class.java)
    }

    companion object {
        private const val TAG = "ProfileFragment"
    }
}