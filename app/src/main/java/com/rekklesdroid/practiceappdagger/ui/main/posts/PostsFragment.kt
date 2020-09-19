package com.rekklesdroid.practiceappdagger.ui.main.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rekklesdroid.practiceappdagger.R
import com.rekklesdroid.practiceappdagger.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created on 9/19/2020 by eduard.kovalchuk
 */
class PostsFragment: DaggerFragment() {

    @Inject lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var viewModel: PostsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")

        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated: Posts fragment was created")

        viewModel = ViewModelProvider(this, providerFactory).get(PostsViewModel::class.java)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.observePosts().removeObservers(viewLifecycleOwner)
        viewModel.observePosts().observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "subscribeObservers: ${it.data}")
        })
    }

    companion object {
        private const val TAG = "PostsFragment"
    }
}