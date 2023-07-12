package com.example.boljistudij.features.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boljistudij.R
import com.example.boljistudij.features.login.domain.LoginRepository
import com.example.boljistudij.features.login.view.LoginAction
import com.example.boljistudij.features.login.view.LoginEvent
import com.example.boljistudij.features.login.view.LoginUiState
import com.example.boljistudij.networking.Failure
import com.example.boljistudij.utils.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val resourceProvider: ResourceProvider,
) : ViewModel() {

    val uiStateFlow = MutableStateFlow(
        LoginUiState(
            isButtonEnabled = false,
            isLoading = false
        )
    )

    val eventsFlow = MutableSharedFlow<LoginEvent>()

    private suspend fun onLoginClicked(emailText: String, passwordText: String) {
        showLoading(true)
        val response =
            loginRepository.login(emailText, passwordText)

        response.either(::handleLoginFailure) { loginData ->
            showLoading(false)
            emitEvent(LoginEvent.LoginSuccessful(loginData.userType))
        }
    }

    fun onAction(action: LoginAction) {
        viewModelScope.launch {
            when (action) {
                is LoginAction.LoginButtonClicked -> onLoginClicked(
                    action.email,
                    action.password
                )
                is LoginAction.InputChanged -> onInputChanged(action.email, action.password)
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        uiStateFlow.update {
            it.copy(
                isLoading = isLoading
            )
        }
    }

    private fun onInputChanged(emailText: String, passwordText: String) {
        val isButtonEnabled = emailText.isNotEmpty() && passwordText.isNotEmpty()
        uiStateFlow.update {
            it.copy(
                isButtonEnabled = isButtonEnabled,
            )
        }
    }

    private suspend fun emitEvent(event: LoginEvent) {
        eventsFlow.emit(event)
    }

    private fun handleLoginFailure(failure: Failure) {
        viewModelScope.launch {
            showLoading(false)
            when (failure) {
                Failure.NetworkError -> {
                    eventsFlow.emit(
                        LoginEvent.ShowError(
                            message = resourceProvider.getString(R.string.no_network_connection)
                        )
                    )
                }
                is Failure.ApiError, Failure.UnknownError -> {
                    eventsFlow.emit(
                        LoginEvent.ShowError(
                            message = resourceProvider.getString(R.string.wrong_email)
                        )
                    )
                }
            }
        }
    }
}