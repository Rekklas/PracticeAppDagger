package com.rekklesdroid.practiceappdagger.di.main

import com.rekklesdroid.practiceappdagger.network.main.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
@Module
object MainModule {

    @Provides
    fun provideMainApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }
}