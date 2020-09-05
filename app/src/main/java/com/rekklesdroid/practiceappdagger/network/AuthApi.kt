package com.rekklesdroid.practiceappdagger.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created on 9/5/2020 by eduard.kovalchuk
 */
interface AuthApi {

    @GET
    fun getFakeStuff(): Call<ResponseBody>
}