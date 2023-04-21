package com.upb.certupb2023.mainscreen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.upb.certupb2023.databinding.ActivityMainBinding
import com.upb.certupb2023.mainscreen.fragments.home.viewmodels.HomeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Vincular un bottom navigation view a un Nav Graph (forma simple)
        val navController = binding.navHostFragment.getFragment<NavHostFragment>().navController
        binding.bottomNavigationView.setupWithNavController(navController)

        // Manejo manual del bottom navigation view (forma larga), saltar a cualquier parte del nav graph:

//        bottomNavigationView.setOnItemSelectedListener {
//            findNavController(R.id.nav_host_fragment).navigate(
//                when (it.itemId) {
//                    R.id.menu_item_home -> R.id.listFragment
//                    R.id.menu_item_store -> R.id.myStoreFragment
//                    R.id.menu_item_settings -> R.id.settingsFragment
//                    else -> R.id.listFragment
//                }
//            )
//            true
//        }

        // Logica de back button ya no es necesaria en el caso del uso del Nav Graph
//        onBackPressedDispatcher.addCallback(
//            this,
//            object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    if (homeFragment.isVisible && homeFragment.childFragmentManager.fragments.size > 1) {
//                        homeFragment.childFragmentManager.removeLastFragment()
//                    } else if (settingsFragment.isVisible || myStoreFragment.isVisible) {
//                        supportFragmentManager.replaceFragment(homeFragment, R.id.fragment_container)
//                    } else {
//                        finish()
//                    }
//                }
//            }
//        )
    }
}