package com.capstone.arahku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstone.arahku.databinding.ActivityMainBinding
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.ui.LandingPageActivity
import com.capstone.arahku.ui.chat.ChatFragment
import com.capstone.arahku.ui.friend.FriendFragment
import com.capstone.arahku.ui.home.HomeFragment
import com.capstone.arahku.ui.info_jurusan.InfoJurusanFragment
import com.capstone.arahku.ui.profile.ProfileFragment
import com.capstone.arahku.viewmodel.LoginViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomeFragment())
        bottomNav = binding.navView as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_chat -> {
                    loadFragment(ChatFragment())
                    true
                }
                R.id.navigation_info_jurusan -> {
                    loadFragment(InfoJurusanFragment())
                    true
                }
                R.id.navigation_teman -> {
                    loadFragment(FriendFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> true
            }
        }
        viewModelSetup()

    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    private fun viewModelSetup(){
        val pref = UserPreference.getInstance(dataStore)
        viewModel = ViewModelProvider(this, ViewModelFactory(pref))[LoginViewModel::class.java]

        viewModel.getState().observe(this@MainActivity){ isLogin ->
            if (isLogin == false){
                startActivity(Intent(this@MainActivity, LandingPageActivity::class.java))
                finish()
            }
        }
    }
}