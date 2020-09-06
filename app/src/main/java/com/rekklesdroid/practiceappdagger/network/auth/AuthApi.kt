package com.rekklesdroid.practiceappdagger.network.auth

import com.rekklesdroid.practiceappdagger.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
interface AuthApi {

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Flowable<User>
}