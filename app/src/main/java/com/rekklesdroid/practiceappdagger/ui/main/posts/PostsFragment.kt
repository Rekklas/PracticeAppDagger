package com.rekklesdroid.practiceappdagger.ui.main.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rekklesdroid.practiceappdagger.R
import com.rekklesdroid.practiceappdagger.utils.Resource
import com.rekklesdroid.practiceappdagger.utils.VerticalSpaceItemDecoration
import com.rekklesdroid.practiceappdagger.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

/**
 * Created on 9/19/2020 by eduard.kovalchuk
 */
class PostsFragment: DaggerFragment() {

    @Inject lateinit var providerFactory: ViewModelProviderFactory
    @Inject lateinit var postsRecyclerAdapter: PostsRecyclerAdapter
    @Inject lateinit var linearLayoutManager: LinearLayoutManager
    @Inject lateinit var verticalSpaceItemDecoration: VerticalSpaceItemDecoration

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

        initRecyclerView()
        subscribeObservers()
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = linearLayoutManager
            addItemDecoration(verticalSpaceItemDecoration)
            adapter = postsRecyclerAdapter
        }

    }

    private fun subscribeObservers() {
        viewModel.observePosts().removeObservers(viewLifecycleOwner)
        viewModel.observePosts().observe(viewLifecycleOwner, Observer {
            when(it) {
                is Resource.Success -> {
                    Log.d(TAG, "subscribeObservers: Success")
                    it.data?.let { list ->
                        postsRecyclerAdapter.posts = list
                    }
                }
                is Resource.Loading -> {
                    Log.d(TAG, "subscribeObservers: Loading")
                }
                is Resource.Error -> {
                    Log.e(TAG, "subscribeObservers: Error - ${it.message}")
                }
            }
        })
    }

    companion object {
        private const val TAG = "PostsFragment"
    }
}