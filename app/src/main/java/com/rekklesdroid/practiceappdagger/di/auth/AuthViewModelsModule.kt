package com.rekklesdroid.practiceappdagger.di.auth

import androidx.lifecycle.ViewModel
import com.rekklesdroid.practiceappdagger.di.ViewModelKey
import com.rekklesdroid.practiceappdagger.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
@Module
abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel
}