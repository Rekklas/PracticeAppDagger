package com.rekklesdroid.practiceappdagger.di

import androidx.lifecycle.ViewModelProvider
import com.rekklesdroid.practiceappdagger.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}