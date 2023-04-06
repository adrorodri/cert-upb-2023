package com.upb.certupb2023.mainscreen.fragments.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upb.certupb2023.R
import com.upb.certupb2023.mainscreen.fragments.home.adapters.HomeListAdapter
import com.upb.certupb2023.mainscreen.fragments.home.models.HomeListItem

class ListFragment : Fragment() {

    val detailsFragment = DetailsFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listItems = listOf(
            HomeListItem("Elemento 1", R.drawable.img_background),
            HomeListItem("Elemento 2", R.drawable.img_background),
            HomeListItem("Elemento 3", R.drawable.img_background)
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = HomeListAdapter(listItems) {
            val ft = parentFragmentManager.beginTransaction()
            ft.add(R.id.home_child_container, detailsFragment)
            ft.commit()
        }
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}