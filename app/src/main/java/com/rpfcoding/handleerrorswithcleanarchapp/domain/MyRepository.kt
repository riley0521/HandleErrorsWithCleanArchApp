package com.rpfcoding.handleerrorswithcleanarchapp.domain

import com.rpfcoding.handleerrorswithcleanarchapp.util.Resource

interface MyRepository {

    suspend fun submitEmail(email: String): Resource<Unit>
}