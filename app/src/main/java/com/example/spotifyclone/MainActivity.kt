package com.example.spotifyclone

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.spotifyclone.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

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
            change_btnState(binding.btnHome,R.drawable.icon_home_filled)
        }

        binding.btnSearch.setOnClickListener{
            loadFragment(SearchFragment())
            change_btnState(binding.btnSearch,R.drawable.icon_search_filled)
        }

        binding.btnLibrary.setOnClickListener(){
            loadFragment(LibraryFragment())
            change_btnState(binding.btnLibrary,R.drawable.icon_library_filled)
        }

        binding.btnPremium.setOnClickListener{
            loadFragment(PremiumFragment())
            change_btnState(binding.btnPremium,R.drawable.icon_premium_filled)
        }

    }

    private fun loadFragment(fragment: Fragment){
        val fm: FragmentManager = supportFragmentManager;
        val ft:FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.frag_container,fragment)
        ft.commit()
    }

    private fun change_btnState(btn: MaterialButton,icon: Int){
        btn.icon =  ContextCompat.getDrawable(this,icon)
        btn.setTextColor(ContextCompat.getColorStateList(this, R.color.white))
    }
//    private fun change_btnState(btn: MaterialButton) {
//        val color = ContextCompat.getColor(this, R.color.white) // Replace with your desired color resource
//        btn.iconTint = ColorStateList.valueOf(color)
//        btn.setTextColor(ColorStateList.valueOf(color))
//    }
}
