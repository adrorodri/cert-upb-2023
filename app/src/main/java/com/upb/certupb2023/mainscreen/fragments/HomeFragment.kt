package com.upb.certupb2023.mainscreen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.upb.certupb2023.R

class HomeFragment : Fragment() {

    val detailsFragment = DetailsFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnGoToDetails = view.findViewById<Button>(R.id.btn_go_to_details)
        btnGoToDetails.setOnClickListener {
            val ft = parentFragmentManager.beginTransaction()
            ft.add(R.id.fragment_container, detailsFragment)
            ft.commit()
        }
    }
}