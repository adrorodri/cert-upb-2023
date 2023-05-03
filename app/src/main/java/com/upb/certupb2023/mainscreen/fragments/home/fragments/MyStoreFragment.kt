package com.upb.certupb2023.mainscreen.fragments.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upb.certupb2023.databinding.FragmentMyStoreBinding
import com.upb.certupb2023.databinding.FragmentProfileBinding

class MyStoreFragment: Fragment() {
    lateinit var binding: FragmentMyStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}