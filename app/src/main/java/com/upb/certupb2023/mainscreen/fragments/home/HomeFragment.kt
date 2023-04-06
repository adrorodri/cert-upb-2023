package com.upb.certupb2023.mainscreen.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.upb.certupb2023.R
import com.upb.certupb2023.mainscreen.fragments.home.fragments.ListFragment

class HomeFragment : Fragment() {

    val homeFragment = ListFragment()
    var backButton: OnBackPressedCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val ft = childFragmentManager.beginTransaction()
        ft.add(R.id.home_child_container, homeFragment)
        ft.commit()
    }
}