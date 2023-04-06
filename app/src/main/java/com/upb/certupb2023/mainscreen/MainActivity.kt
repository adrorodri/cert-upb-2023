package com.upb.certupb2023.mainscreen

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upb.certupb2023.R
import com.upb.certupb2023.mainscreen.fragments.home.HomeFragment
import com.upb.certupb2023.mainscreen.fragments.mystore.MyStoreFragment
import com.upb.certupb2023.mainscreen.fragments.settings.SettingsFragment
import removeLastFragment
import replaceFragment

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val myStoreFragment = MyStoreFragment()
    private val settingsFragment = SettingsFragment()

    var backButton: OnBackPressedCallback? = null

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.replaceFragment(homeFragment, R.id.fragment_container)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener {
            supportFragmentManager.replaceFragment(
                when (it.itemId) {
                    R.id.menu_item_home -> homeFragment
                    R.id.menu_item_store -> myStoreFragment
                    R.id.menu_item_settings -> settingsFragment
                    else -> homeFragment
                }, R.id.fragment_container
            )
            true
        }

        // Configurar Back Button con un comportamiento personalizado:
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (homeFragment.isVisible && homeFragment.childFragmentManager.fragments.size > 1) {
                        homeFragment.childFragmentManager.removeLastFragment()
                    } else if (settingsFragment.isVisible || myStoreFragment.isVisible) {
                        supportFragmentManager.replaceFragment(homeFragment, R.id.fragment_container)
                    } else {
                        finish()
                    }
                }
            }
        )
    }
}