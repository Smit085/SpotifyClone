package com.example.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.spotifyclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadFragment(HomeFragment())

        binding.btnHome.setOnClickListener {
            loadFragment(HomeFragment())
        }

        binding.btnSearch.setOnClickListener{
            loadFragment(SearchFragment())
        }

        binding.btnLibrary.setOnClickListener(){
            loadFragment(LibraryFragment())
        }

        binding.btnPremium.setOnClickListener{
            loadFragment(PremiumFragment())
        }
    }

    private fun loadFragment(fragment: Fragment){
        val fm: FragmentManager = supportFragmentManager;
        val ft:FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.frag_container,fragment)
        ft.commit()
    }
}
