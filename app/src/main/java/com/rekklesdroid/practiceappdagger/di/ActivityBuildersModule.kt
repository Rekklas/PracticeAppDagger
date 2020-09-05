package com.rekklesdroid.practiceappdagger.di

import com.rekklesdroid.practiceappdagger.di.auth.AuthModule
import com.rekklesdroid.practiceappdagger.di.auth.AuthViewModelsModule
import com.rekklesdroid.practiceappdagger.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created on 8/28/2020 by eduard.kovalchuk
 */
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [
        AuthViewModelsModule::class, AuthModule::class
    ])
    abstract fun contributeAuthActivity(): AuthActivity
}