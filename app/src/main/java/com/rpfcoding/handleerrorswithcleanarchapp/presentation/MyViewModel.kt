package com.rpfcoding.handleerrorswithcleanarchapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rpfcoding.handleerrorswithcleanarchapp.R
import com.rpfcoding.handleerrorswithcleanarchapp.domain.SubmitEmailUseCase
import com.rpfcoding.handleerrorswithcleanarchapp.util.Resource
import com.rpfcoding.handleerrorswithcleanarchapp.util.UiText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyViewModel(
    private val submitEmailUseCase: SubmitEmailUseCase = SubmitEmailUseCase()
): ViewModel() {

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _error = MutableStateFlow<UiText?>(null)
    val error = _error.asStateFlow()

    fun onEmailChanged(text: String) {
        _email.update { text }
    }

    fun submitEmail() {
        viewModelScope.launch {
            when(val res = submitEmailUseCase(email.value)) {
                is Resource.Error -> {
                    _error.update { res.message }
                }
                is Resource.Success -> {
                    _error.update { UiText.StringResource(R.string.authenticated) }
                }
            }
        }
    }
}