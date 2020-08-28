package com.rekklesdroid.practiceappdagger

import com.rekklesdroid.practiceappdagger.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created on 8/28/2020 by eduard.kovalchuk
 */
class BaseApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}