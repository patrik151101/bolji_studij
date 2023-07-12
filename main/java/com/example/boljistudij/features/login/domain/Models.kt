package com.example.boljistudij.features.login.domain

enum class UserType {
    STUDENT,
    TEACHER,
}

data class LoginData(
    val userId: Int,
    val username: String,
    val password: String,
    val userType: UserType,
    val fullname: String,
)