package com.upb.certupb2023.mainscreen.fragments.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.upb.certupb2023.R

class DetailsFragment: Fragment() {

    // Con la siguiente linea automaticamente se reciben los argumentos de SafeArgs
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Ya podemos utilizar los argumentos en lo que necesitemos, como mostrarlos en el UI
        view.findViewById<TextView>(R.id.textView4).text = args.homeListItem.title
    }
}