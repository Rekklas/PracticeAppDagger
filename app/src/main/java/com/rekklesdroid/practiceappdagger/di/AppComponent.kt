package com.rekklesdroid.practiceappdagger.di

import android.app.Application
import com.rekklesdroid.practiceappdagger.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created on 8/28/2020 by eduard.kovalchuk
 */
@Component(modules = [AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}