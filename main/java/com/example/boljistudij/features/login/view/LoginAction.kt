package com.example.boljistudij.features.login.view

sealed interface LoginAction {
    data class LoginButtonClicked(val email: String, val password: String) : LoginAction
    data class InputChanged(val email: String, val password: String) : LoginAction
}