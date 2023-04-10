package com.upb.certupb2023.mainscreen.fragments.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.upb.certupb2023.R
import com.upb.certupb2023.mainscreen.fragments.home.adapters.HomeListAdapter
import com.upb.certupb2023.mainscreen.fragments.home.models.HomeListItem
import com.upb.certupb2023.mainscreen.fragments.home.models.Tag

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
            HomeListItem("Elemento 1", R.drawable.img_background, "https://media.istockphoto.com/id/908909714/pt/vetorial/vector-group-of-pets-dog-cat-parrot-on-white-background-beautiful-pet-symbol-pet-icon-easy.jpg?s=612x612&w=0&k=20&c=MobzGBzk0u9-ghIwcQi1ujJtapkFf0gIrqFrjoWRTL0=", listOf(Tag.STORE, Tag.PETS)),
            HomeListItem("Elemento 2", R.drawable.img_background, "https://images-platform.99static.com//N4VUoRJLktkazbY_0VENbLXlRyI=/13x0:1589x1576/fit-in/500x500/99designs-contests-attachments/98/98546/attachment_98546587", listOf(Tag.JEWELERY)),
            HomeListItem("Elemento 3", R.drawable.img_background, "https://img.freepik.com/free-vector/pet-logo-design-paw-vector-animal-shop-business_53876-136741.jpg?w=2000", listOf())
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = HomeListAdapter(listItems) {
            val ft = parentFragmentManager.beginTransaction()
            ft.add(R.id.home_child_container, detailsFragment)
            ft.commit()
        }
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

//        recyclerView.layoutManager = GridLayoutManager(context, 2)

//        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}