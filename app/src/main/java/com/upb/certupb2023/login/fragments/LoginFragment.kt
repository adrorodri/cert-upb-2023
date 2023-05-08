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
import com.upb.certupb2023.databinding.FragmentLoginBinding
import com.upb.certupb2023.databinding.FragmentRegisterBinding
import com.upb.certupb2023.login.fragments.viewmodels.RegisterViewModel
import com.upb.certupb2023.login.models.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    val registerViewModel: RegisterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.viewModel = registerViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            registerViewModel.login(
                binding.etUsername.text.toString(),
                binding.etPassword.text.toString(), {
                activity?.finish()
            }, {
                Toast.makeText(
                    requireContext(),
                    "Ocurrio un error, intenta nuevamente",
                    Toast.LENGTH_LONG
                ).show()
            })
        }
    }
}