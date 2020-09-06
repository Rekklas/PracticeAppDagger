package com.rekklesdroid.practiceappdagger.ui.auth

/**
 * Created on 9/6/2020 by eduard.kovalchuk
 */
// A generic class that contains authentication data and status about loading this data.
sealed class AuthResource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Authenticated<T>(data: T) : AuthResource<T>(data)
    class Loading<T>(data: T? = null) : AuthResource<T>(data)
    class Error<T>(message: String, data: T? = null) : AuthResource<T>(data, message)
    class NotAuthenticated<T>(): AuthResource<T>()
}