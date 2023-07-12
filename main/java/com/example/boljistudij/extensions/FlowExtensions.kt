package com.example.boljistudij.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun <T> Flow<T>.observe(lifecycleOwner: LifecycleOwner, action: suspend (T) -> Unit): Job =
    flowWithLifecycle(lifecycleOwner.lifecycle)
        .onEach(action)
        .launchIn(lifecycleOwner.lifecycleScope)