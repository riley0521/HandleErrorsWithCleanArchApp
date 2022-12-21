package com.rpfcoding.handleerrorswithcleanarchapp.data

import com.rpfcoding.handleerrorswithcleanarchapp.R
import com.rpfcoding.handleerrorswithcleanarchapp.domain.MyRepository
import com.rpfcoding.handleerrorswithcleanarchapp.util.Resource
import com.rpfcoding.handleerrorswithcleanarchapp.util.UiText
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyRepositoryImpl : MyRepository {

    override suspend fun submitEmail(email: String): Resource<Unit> {
        delay(500L)
        return if(Random.nextBoolean()) {
            Resource.Success(Unit)
        } else {
            if(Random.nextBoolean()) {
                Resource.Error(UiText.DynamicString("Server error."))
            } else {
                Resource.Error(UiText.StringResource(R.string.not_authenticated))
            }
        }
    }
}