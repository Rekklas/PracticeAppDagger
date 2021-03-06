package com.rekklesdroid.practiceappdagger.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created on 9/6/2020 by eduard.kovalchuk
 */
data class User(

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("website")
    @Expose
    var website: String? = null
)