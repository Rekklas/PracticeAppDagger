package com.rekklesdroid.practiceappdagger.network.main

import com.rekklesdroid.practiceappdagger.models.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created on 9/15/2020 by eduard.kovalchuk
 */
interface MainApi {

    // /posts?userId=1
    @GET("posts")
    fun getPostsFromUser(
        @Query("userId") userId: Int
    ): Flowable<List<Post>>
}