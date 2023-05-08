package com.upb.certupb2023.mainscreen.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.upb.certupb2023.R
import com.upb.certupb2023.databinding.FragmentSettingsBinding
import com.upb.certupb2023.mainscreen.fragments.home.viewmodels.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class SettingsFragment : Fragment() {
    lateinit var binding: FragmentSettingsBinding

    val homeViewModel: HomeViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogout.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                homeViewModel.logout().collect()
            }
        }
    }
}