package com.example.boljistudij.views.status

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.example.boljistudij.R

sealed class StatusViewState(
    @ColorRes val backgroundColorId: Int,
    @DrawableRes val drawableId: Int,
    open val message: String?,
) {
    data class Success(override val message: String?) :
        StatusViewState(R.color.primary, R.drawable.ic_success_round, message)

    data class Info(override val message: String?) :
        StatusViewState(R.color.info, R.drawable.ic_info, message)

    data class Error(override val message: String?) :
        StatusViewState(R.color.error, R.drawable.ic_error_red, message)
}