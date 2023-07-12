package com.example.boljistudij.features.login.domain

import com.example.boljistudij.networking.EitherResult

interface LoginRepository {
    suspend fun login(email: String, password: String): EitherResult<LoginData>
}