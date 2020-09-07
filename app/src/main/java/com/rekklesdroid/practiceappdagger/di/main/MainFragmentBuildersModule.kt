package com.rekklesdroid.practiceappdagger.di.main

import com.rekklesdroid.practiceappdagger.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created on 9/7/2020 by eduard.kovalchuk
 */
@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
}