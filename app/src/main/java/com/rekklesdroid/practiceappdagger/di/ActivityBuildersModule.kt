package com.rekklesdroid.practiceappdagger.di

import com.rekklesdroid.practiceappdagger.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created on 8/28/2020 by eduard.kovalchuk
 */
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity
}