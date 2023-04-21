package com.upb.certupb2023.mainscreen.fragments.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upb.certupb2023.R
import com.upb.certupb2023.databinding.FragmentListBinding
import com.upb.certupb2023.mainscreen.fragments.home.adapters.HomeListAdapter
import com.upb.certupb2023.mainscreen.fragments.home.viewmodels.HomeViewModel
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.Tag

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding

    val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = this
        return binding.root
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
        binding.recyclerView.adapter = HomeListAdapter(listItems) {
            // Con SafeArgs (recomendado)
            view.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(it))

            // Sin SafeArgs, no tiene el argumento
//            view.findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
        }
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.include.btnAccount.setOnClickListener {
            view.findNavController().navigate(R.id.loginActivity)
        }

//        recyclerView.layoutManager = GridLayoutManager(context, 2)
//        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}