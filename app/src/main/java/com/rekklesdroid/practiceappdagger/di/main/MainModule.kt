package com.rekklesdroid.practiceappdagger.di.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.rekklesdroid.practiceappdagger.network.main.MainApi
import com.rekklesdroid.practiceappdagger.ui.main.MainActivity
import com.rekklesdroid.practiceappdagger.ui.main.posts.PostsRecyclerAdapter
import com.rekklesdroid.practiceappdagger.utils.VerticalSpaceItemDecoration
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
@Module
object MainModule {

    @MainScope
    @Provides
    fun providePostsRecyclerAdapter(): PostsRecyclerAdapter {
        return PostsRecyclerAdapter()
    }

    @MainScope
    @Provides
    fun provideLinearLayoutManager(mainActivity: MainActivity): LinearLayoutManager {
        return LinearLayoutManager(mainActivity)
    }

    @MainScope
    @Provides
    fun provideVerticalSpaceItemDecorator(): VerticalSpaceItemDecoration {
        return VerticalSpaceItemDecoration(15)
    }

    @MainScope
    @Provides
    fun provideMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }
}