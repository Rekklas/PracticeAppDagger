package com.rekklesdroid.practiceappdagger.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created on 9/15/2020 by eduard.kovalchuk
 */
data class Post(

    @SerializedName("userId")
    @Expose
    val userId: Int,

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("body")
    @Expose
    var body: String? = null
)