package com.example.boljistudij.utils

import android.content.Context
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResourceProvider @Inject constructor(
    @ApplicationContext private val appContext: Context,
) {

    fun getString(@StringRes stringResId: Int) = appContext.getString(stringResId)

    fun getString(@StringRes stringResId: Int, vararg formatArgs: Any) =
        appContext.getString(stringResId, *formatArgs)

    fun getInteger(@IntegerRes intResId: Int) = appContext.resources.getInteger(intResId)
}