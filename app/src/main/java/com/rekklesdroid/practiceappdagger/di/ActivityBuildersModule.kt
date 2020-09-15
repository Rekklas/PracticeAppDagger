package com.rekklesdroid.practiceappdagger.di

import com.rekklesdroid.practiceappdagger.di.auth.AuthModule
import com.rekklesdroid.practiceappdagger.di.auth.AuthViewModelsModule
import com.rekklesdroid.practiceappdagger.di.main.MainFragmentBuildersModule
import com.rekklesdroid.practiceappdagger.di.main.MainModule
import com.rekklesdroid.practiceappdagger.di.main.MainViewModelsModule
import com.rekklesdroid.practiceappdagger.ui.auth.AuthActivity
import com.rekklesdroid.practiceappdagger.ui.main.MainActivity
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

    @ContributesAndroidInjector(modules = [
        MainFragmentBuildersModule::class, MainViewModelsModule::class, MainModule::class
    ])
    abstract fun contributeMainActivity(): MainActivity
}