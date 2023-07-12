package com.example.boljistudij.features.login.view

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.boljistudij.R
import com.example.boljistudij.databinding.FragmentLoginBinding
import com.example.boljistudij.extensions.hideKeyboard
import com.example.boljistudij.extensions.hideProgress
import com.example.boljistudij.extensions.observe
import com.example.boljistudij.extensions.showProgress
import com.example.boljistudij.extensions.showStatusView
import com.example.boljistudij.features.home.view.HomeFragment
import com.example.boljistudij.features.login.viewmodel.LoginViewModel
import com.example.boljistudij.features.splash.SplashFragmentDirections
import com.example.boljistudij.views.status.StatusViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewBinding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.setupListeners()
        observeEvents(view)
        observeState()
    }

    private fun observeState() {
        viewModel.uiStateFlow.observe(viewLifecycleOwner) { uiState ->
            viewBinding.loginButton.isEnabled = uiState.isButtonEnabled

            viewBinding.loginButton.backgroundTintList = ContextCompat.getColorStateList(
                requireContext(),
                if (uiState.isButtonEnabled) R.color.blue else R.color.view_disabled
            )

            if (uiState.isLoading) {
                showProgress()
            } else {
                hideProgress()
            }
        }
    }

    private fun observeEvents(view: View) {
        viewModel.eventsFlow.observe(viewLifecycleOwner) { event ->
            when (event) {
                is LoginEvent.LoginSuccessful -> {
                    viewBinding.editTextUsername.showSuccess()
                    viewBinding.editTextPassword.showSuccess()
                    requireActivity().hideKeyboard()
                    view.clearFocus()

                    val directions = LoginFragmentDirections.actionLoginToHome()
                    findNavController().navigate(directions)
                }
                is LoginEvent.ShowError -> {
                    with(event.message) {
                        showStatusView(StatusViewState.Error(this))
                        viewBinding.textInputLayoutEmail.error = this
                        viewBinding.textInputLayoutPassword.error = this
                    }
                }
            }
        }
    }

    private fun FragmentLoginBinding.setupListeners() {
        editTextPassword.doAfterTextChanged {
            onTextChanged()
        }

        editTextUsername.doAfterTextChanged {
            onTextChanged()
        }

        loginButton.setOnClickListener {
            viewModel.onAction(
                LoginAction.LoginButtonClicked(
                    viewBinding.editTextUsername.text.toString(),
                    viewBinding.editTextPassword.text.toString()
                )
            )
        }
    }

    private fun onTextChanged() {
        viewModel.onAction(
            LoginAction.InputChanged(
                viewBinding.editTextUsername.text.toString(),
                viewBinding.editTextPassword.text.toString()
            )
        )
        hideError()
    }

    private fun EditText.showSuccess() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            ContextCompat.getDrawable(requireContext(), R.drawable.ic_success),
            null
        )
    }

    private fun hideError() {
        viewBinding.textInputLayoutEmail.error = null
        viewBinding.textInputLayoutPassword.error = null
    }
}