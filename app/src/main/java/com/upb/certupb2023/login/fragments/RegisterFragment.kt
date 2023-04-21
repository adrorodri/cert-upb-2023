package com.upb.certupb2023.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import com.upb.certupb2023.R
import com.upb.certupb2023.databinding.FragmentRegisterBinding
import com.upb.certupb2023.login.fragments.viewmodels.RegisterViewModel
import com.upb.certupb2023.login.models.User

class RegisterFragment: Fragment() {
    lateinit var binding: FragmentRegisterBinding

    val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.viewModel = registerViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreateAccount.setOnClickListener {
            if (registerViewModel.user.value == null) return@setOnClickListener

            if (registerViewModel.user.value!!.username.isEmpty() || registerViewModel.user.value!!.email.isBlank()) {
                Toast.makeText(context, getString(R.string.register_toast_user_empty), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (registerViewModel.user.value!!.password.isEmpty() || registerViewModel.user.value!!.password.isBlank()) {
                Toast.makeText(context, getString(R.string.register_toast_password_empty), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (registerViewModel.user.value!!.password != registerViewModel.confirmPassword.value) {
                Toast.makeText(context, getString(R.string.register_toast_password_error), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            registerViewModel.createUser(registerViewModel.user.value!!)
            activity?.finish()
//            findNavController().popBackStack(R.id.loginOptionsFragment, true)
//            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToMainActivity())
        }
    }
}