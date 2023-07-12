package com.example.boljistudij.views.status

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.boljistudij.R
import com.example.boljistudij.databinding.ViewStatusBinding

class StatusView : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding = ViewStatusBinding.inflate(LayoutInflater.from(context), this)

    fun setupState(state: StatusViewState) {
        binding.root.background = ContextCompat.getDrawable(context, state.backgroundColorId)
        binding.image.setImageResource(state.drawableId)
        message = state.message
    }

    var message: String? = null
        set(value) {
            field = value
            if (value == null) return

            val animation = AnimationUtils.loadAnimation(context, R.anim.error_animation)
            binding.root.clearAnimation()
            binding.root.startAnimation(animation)
            binding.message.text = value
        }
}