package com.example.boljistudij.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import com.example.boljistudij.R
import com.example.boljistudij.databinding.ViewProgressBinding

class FullScreenCircularProgressView : RelativeLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        isClickable = true
        isFocusable = true
        elevation = ELEVATION
        setBackgroundResource(R.color.white_transparent)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }

    private val binding = ViewProgressBinding.inflate(LayoutInflater.from(context), this)

    fun show() {
        binding.root.isVisible = true
    }

    fun hide() {
        binding.root.isVisible = false
    }

    companion object {
        private const val ELEVATION = 100f
    }

}