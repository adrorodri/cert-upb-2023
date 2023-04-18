package com.upb.certupb2023.mainscreen.fragments.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.upb.certupb2023.R
import com.upb.certupb2023.databinding.FragmentDetailsBinding
import com.upb.certupb2023.mainscreen.models.Tag

class DetailsFragment: Fragment() {

    // Con la siguiente linea automaticamente se reciben los argumentos de SafeArgs
    val args: DetailsFragmentArgs by navArgs()
    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeListItem = args.homeListItem



        // Ya podemos utilizar los argumentos en lo que necesitemos, como mostrarlos/actualizarlos en el UI
        Glide.with(view).load(args.homeListItem.coverImageUrl).into(binding.ivCover)
        Glide.with(view).load(args.homeListItem.logoUrl).circleCrop().into(binding.ivLogo)

        args.homeListItem.tags.forEach {
            val tagView = LayoutInflater.from(context).inflate(R.layout.home_list_item_tag, binding.lyTags, false)
            tagView.findViewById<ImageView>(R.id.ivTagIcon).setImageResource(when(it) {
                Tag.STORE -> R.drawable.ic_store
                Tag.PETS -> R.drawable.ic_person
                Tag.JEWELERY -> R.drawable.ic_phone
            })
            binding.lyTags.addView(tagView)
        }

//        binding.tvTitle.text = args.homeListItem.title
    }
}