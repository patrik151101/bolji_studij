package com.example.boljistudij.features.login.data

import com.example.boljistudij.features.login.domain.LoginData
import com.example.boljistudij.features.login.domain.LoginRepository
import com.example.boljistudij.features.login.domain.UserType
import com.example.boljistudij.networking.Either
import com.example.boljistudij.networking.EitherResult
import com.example.boljistudij.networking.Failure

class LoginRepositoryImpl() : LoginRepository {

    override suspend fun login(email: String, password: String): EitherResult<LoginData> {
        return if (email == "examples@tvz.hr") {
            Either.Right(
                LoginData(
                    userId = 1234,
                    userType = UserType.STUDENT,
                    password = "jedandvatri",
                    username = "parambasi",
                    fullname = "Patrik Arambasic"
                )
            )
        } else {
            Either.Left(Failure.UnknownError)
        }
    }
}