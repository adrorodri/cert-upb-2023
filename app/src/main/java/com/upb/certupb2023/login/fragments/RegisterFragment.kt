package com.upb.certupb2023.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.upb.certupb2023.R
import com.upb.certupb2023.databinding.FragmentRegisterBinding
import com.upb.certupb2023.login.models.User

class RegisterFragment: Fragment() {
    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.user = User("Juan Perez", "jperez@gmail.com", "cachuchin123")
        binding.confirmPassword = ""

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreateAccount.setOnClickListener {
            if ((binding.user as User).username.isEmpty() || (binding.user as User).email.isBlank()) {
                Toast.makeText(context, getString(R.string.register_toast_user_empty), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if ((binding.user as User).password.isEmpty() || (binding.user as User).password.isBlank()) {
                Toast.makeText(context, getString(R.string.register_toast_password_empty), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if ((binding.user as User).password != binding.etConfirmPassword.text.toString()) {
                Toast.makeText(context, getString(R.string.register_toast_password_error), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            println(binding.user.toString())
        }
    }
}