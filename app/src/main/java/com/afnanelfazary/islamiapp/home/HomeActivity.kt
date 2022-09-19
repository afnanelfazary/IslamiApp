package com.afnanelfazary.islamiapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.afnanelfazary.islamiapp.R
import com.afnanelfazary.islamiapp.databinding.ActivityHomeBinding
import com.afnanelfazary.islamiapp.home.hadeth.HadethFragment
import com.afnanelfazary.islamiapp.home.quran.QuranFragment
import com.afnanelfazary.islamiapp.home.radio.RadioFragment
import com.afnanelfazary.islamiapp.home.tasbeh.TasbehFragment
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding  //defining the binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root) // we now set the contentview as the binding.root
        binding.bottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { menuItem ->
            if (menuItem.itemId == R.id.navigation_quran) {
                pushFragment(QuranFragment())

            } else if (menuItem.itemId == R.id.navigation_ahadees) {
                pushFragment(HadethFragment())
            } else if (menuItem.itemId == R.id.navigation_sebha) {
                pushFragment(TasbehFragment())

            } else if (menuItem.itemId == R.id.navigation_radio) {
                pushFragment(RadioFragment())

            }
            return@OnItemSelectedListener true
        })
        binding.bottomNavigation.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}