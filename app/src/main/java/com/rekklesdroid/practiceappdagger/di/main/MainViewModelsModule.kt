package com.rekklesdroid.practiceappdagger.di.main

import androidx.lifecycle.ViewModel
import com.rekklesdroid.practiceappdagger.di.ViewModelKey
import com.rekklesdroid.practiceappdagger.ui.main.posts.PostsViewModel
import com.rekklesdroid.practiceappdagger.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created on 9/7/2020 by eduard.kovalchuk
 */
@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(postsViewModel: PostsViewModel): ViewModel
}