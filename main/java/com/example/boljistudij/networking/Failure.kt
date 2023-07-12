package com.example.boljistudij.networking


sealed interface Failure {
    object NetworkError : Failure
    object UnknownError : Failure
    data class ApiError(val statusCode: Int) : Failure
}