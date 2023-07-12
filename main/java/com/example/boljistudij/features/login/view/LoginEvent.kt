package com.example.boljistudij.features.login.view

import com.example.boljistudij.features.login.domain.UserType

sealed interface LoginEvent {
    data class LoginSuccessful(val userType: UserType) : LoginEvent
    data class ShowError(val message: String) : LoginEvent
}