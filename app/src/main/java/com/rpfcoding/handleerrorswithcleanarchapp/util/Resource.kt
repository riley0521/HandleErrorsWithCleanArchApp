package com.rpfcoding.handleerrorswithcleanarchapp.util

sealed class Resource<T>(data: T? = null, message: UiText? = null) {
    data class Success<T>(val data: T) : Resource<T>(data = data)
    data class Error<T>(val message: UiText): Resource<T>(message = message)
}
