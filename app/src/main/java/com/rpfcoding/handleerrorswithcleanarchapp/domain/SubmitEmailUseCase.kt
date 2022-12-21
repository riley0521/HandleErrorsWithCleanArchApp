package com.rpfcoding.handleerrorswithcleanarchapp.domain

import android.util.Patterns
import com.rpfcoding.handleerrorswithcleanarchapp.R
import com.rpfcoding.handleerrorswithcleanarchapp.data.MyRepositoryImpl
import com.rpfcoding.handleerrorswithcleanarchapp.util.Resource
import com.rpfcoding.handleerrorswithcleanarchapp.util.UiText

class SubmitEmailUseCase(
    private val repository: MyRepository = MyRepositoryImpl()
) {

    suspend operator fun invoke(email: String): Resource<Unit> {
        if(email.isBlank()) {
            return Resource.Error(UiText.StringResource(R.string.blank_email))
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return Resource.Error(UiText.StringResource(R.string.invalid_email))
        }

        return repository.submitEmail(email)
    }
}