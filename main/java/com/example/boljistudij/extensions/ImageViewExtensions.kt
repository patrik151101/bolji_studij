package com.example.boljistudij.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.boljistudij.R

fun ImageView.loadUrl(
    mediaUrl: String,
) {
    Glide
        .with(this)
        .load(mediaUrl)
        .placeholder(R.color.blue)
        .override(this.width, this.height)
        .into(this)
}