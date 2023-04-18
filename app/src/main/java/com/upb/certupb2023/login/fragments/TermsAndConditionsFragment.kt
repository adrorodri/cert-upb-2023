package com.upb.certupb2023.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.upb.certupb2023.databinding.FragmentTermsAndConditionsBinding

class TermsAndConditionsFragment : Fragment() {
    lateinit var binding: FragmentTermsAndConditionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTermsAndConditionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDecline.setOnClickListener { view.findNavController().popBackStack() }
        binding.btnAccept.setOnClickListener {
            view.findNavController()
                .navigate(TermsAndConditionsFragmentDirections.actionTermsAndConditionsFragmentToRegisterFragment())
        }
    }
}