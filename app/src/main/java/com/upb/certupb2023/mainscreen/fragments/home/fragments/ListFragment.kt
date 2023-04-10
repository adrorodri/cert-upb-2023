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
            HomeListItem(
                "Elemento 1",
                "https://images.unsplash.com/photo-1583336663277-620dc1996580?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8ZG9nJTIwY2xvdGhlc3xlbnwwfHwwfHw%3D&w=1000&q=80",
                "https://media.istockphoto.com/id/908909714/pt/vetorial/vector-group-of-pets-dog-cat-parrot-on-white-background-beautiful-pet-symbol-pet-icon-easy.jpg?s=612x612&w=0&k=20&c=MobzGBzk0u9-ghIwcQi1ujJtapkFf0gIrqFrjoWRTL0=",
                listOf(Tag.STORE, Tag.PETS)
            ),
            HomeListItem(
                "Elemento 2",
                "https://sgp1.digitaloceanspaces.com/tz-mag-ph/wp-content/uploads/2022/01/111101015151/best-minimalist-jewelry-brands-770x404.jpg",
                "https://www.logodesign.net/images/home-industry/jewelry-logo-02.jpg",
                listOf(Tag.JEWELERY)
            ),
            HomeListItem(
                "Elemento 3",
                "https://di2ponv0v5otw.cloudfront.net/posts/2020/09/23/5f6bc0651e75a87ebf64c88f/m_5f6bc06ca4de414bb929718d.jpeg",
                "https://media.istockphoto.com/id/874045548/vector/shirt-icon.jpg?s=612x612&w=0&k=20&c=ZJCxsCczemu1XhYRMDCByrYdwotBESuFdC5tkGf1a6g=",
                listOf()
            )
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