package com.upb.certupb2023.mainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import com.upb.certupb2023.R
import com.upb.certupb2023.mainscreen.fragments.HomeFragment
import com.upb.certupb2023.mainscreen.fragments.MyStoreFragment
import com.upb.certupb2023.mainscreen.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    val homeFragment = HomeFragment()
    val myStoreFragment = MyStoreFragment()
    val settingsFragment = SettingsFragment()

    companion object {
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, homeFragment)
        ft.commit()

        val btnHome = findViewById<ImageButton>(R.id.btn_home)
        val btnMyStore = findViewById<ImageButton>(R.id.btn_my_store)
        val btnSettings = findViewById<ImageButton>(R.id.btn_settings)

        btnHome.setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container, homeFragment)
            ft.commit()
        }
        btnMyStore.setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container, myStoreFragment)
            ft.commit()
        }
        btnSettings.setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container, settingsFragment)
            ft.commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.size > 1) {
            val ft = supportFragmentManager.beginTransaction()
            ft.remove(supportFragmentManager.fragments.last())
            ft.commit()
        } else {
            finish()
        }
    }
}