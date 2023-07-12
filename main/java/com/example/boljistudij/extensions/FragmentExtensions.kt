package com.example.boljistudij.extensions

import androidx.fragment.app.Fragment
import com.example.boljistudij.MainActivity
import com.example.boljistudij.views.status.StatusViewState

fun Fragment.showStatusView(state: StatusViewState) {
    (activity as MainActivity).showStatusView(state)
}

fun Fragment.showProgress() {
    (activity as MainActivity).showLoader()
}

fun Fragment.hideProgress() {
    (activity as MainActivity).hideLoader()
}