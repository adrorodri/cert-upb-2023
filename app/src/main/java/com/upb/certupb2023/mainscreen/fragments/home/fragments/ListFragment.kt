package com.upb.certupb2023.mainscreen.fragments.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upb.certupb2023.R
import com.upb.certupb2023.databinding.FragmentListBinding
import com.upb.certupb2023.mainscreen.fragments.home.adapters.HomeListAdapter
import com.upb.certupb2023.mainscreen.fragments.home.adapters.StoryAdapter
import com.upb.certupb2023.mainscreen.fragments.home.viewmodels.HomeViewModel
import com.upb.certupb2023.mainscreen.models.HomeListItem
import com.upb.certupb2023.mainscreen.models.Tag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding

    lateinit var storyAdapter: StoryAdapter
    lateinit var storesAdapter: HomeListAdapter

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
        CoroutineScope(Dispatchers.Main).launch {
            val isUserLoggedIn = homeViewModel.isUserLoggedIn(requireContext())
            if (!isUserLoggedIn) {
                view.findNavController().navigate(R.id.loginActivity)
            }
        }

        homeViewModel.getStoryList()
        homeViewModel.getStoresList(requireContext()) {
            Toast.makeText(requireContext(), "Ocurrio un error", Toast.LENGTH_LONG).show()
        }

        storesAdapter = HomeListAdapter(listOf()){
            // Con SafeArgs (recomendado)
            view.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(it))

            // Sin SafeArgs, no tiene el argumento
//            view.findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
        }

        binding.recyclerView.adapter = storesAdapter

        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.include.btnAccount.setOnClickListener {
            view.findNavController().navigate(R.id.loginActivity)
        }

        storyAdapter = StoryAdapter(listOf())

        binding.include.rvStories.adapter = storyAdapter
        binding.include.rvStories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        homeViewModel.storyList.observe(viewLifecycleOwner) { newStoryList ->
            storyAdapter.storyItemList = newStoryList
            storyAdapter.notifyDataSetChanged()
        }

        homeViewModel.storesList.observe(viewLifecycleOwner) { newStoryList ->
            storesAdapter.itemList = newStoryList
            storesAdapter.notifyDataSetChanged()
        }

        binding.include.editText.addTextChangedListener { newText ->
            homeViewModel.searchStoreList(requireContext(), newText.toString())
        }

//        recyclerView.layoutManager = GridLayoutManager(context, 2)
//        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}