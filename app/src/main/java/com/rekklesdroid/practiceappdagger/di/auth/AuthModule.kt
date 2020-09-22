package com.rekklesdroid.practiceappdagger.di.auth

import com.rekklesdroid.practiceappdagger.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
@Module
object AuthModule {

    @AuthScope
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}