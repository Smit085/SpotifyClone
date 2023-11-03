package com.example.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.spotifyclone.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadFragment(HomeFragment(),0)
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation)
        supportFragmentManager.addOnBackStackChangedListener(this)

        binding.btnHome.setOnClickListener {
            loadFragment(HomeFragment(),0)
            change_btnState(binding.btnHome,R.drawable.icon_home_filled)
            binding.btnHome.startAnimation(scaleAnimation)
        }

        binding.btnSearch.setOnClickListener{
            loadFragment(SearchFragment(),1)
            change_btnState(binding.btnSearch,R.drawable.icon_search_filled)
            binding.btnSearch.startAnimation(scaleAnimation)
        }

        binding.btnLibrary.setOnClickListener(){
            loadFragment(LibraryFragment(),1)
            change_btnState(binding.btnLibrary,R.drawable.icon_library_filled)
            binding.btnLibrary.startAnimation(scaleAnimation)
        }

        binding.btnPremium.setOnClickListener{
            loadFragment(PremiumFragment(),1)
            change_btnState(binding.btnPremium,R.drawable.icon_premium_filled)
            binding.btnPremium.startAnimation(scaleAnimation)
        }

        binding.cardMusiccontrol.setOnClickListener {
            val bottomSheetFragment = MusicPlayer()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        viewModel.selectedSongName.observe(this) { songName ->
            binding.txtSongName.text = songName
        }
    }
    private fun loadFragment(fragment: Fragment,flag: Int){
        val fm: FragmentManager = supportFragmentManager;
        val ft:FragmentTransaction = fm.beginTransaction()
        if (flag == 0) {
            ft.add(R.id.frag_container, fragment);
            fm.popBackStack("root_fragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack("root_fragment");
        } else {
            ft.replace(R.id.frag_container, fragment);
            ft.addToBackStack(null);
        }
        ft.commit()
    }

    private fun change_btnState(btn: MaterialButton,icon: Int){
        reset_btnState()
        btn.icon =  ContextCompat.getDrawable(this,icon)
        btn.setTextColor(ContextCompat.getColorStateList(this, R.color.white))

    }

    private fun reset_btnState(){
        binding.btnHome.icon = ContextCompat.getDrawable(this,R.drawable.icon_home)
        binding.btnSearch.icon = ContextCompat.getDrawable(this,R.drawable.icon_search)
        binding.btnLibrary.icon = ContextCompat.getDrawable(this,R.drawable.icon_library)
        binding.btnPremium.icon = ContextCompat.getDrawable(this,R.drawable.icon_premium)

        binding.btnHome.setTextColor(ContextCompat.getColorStateList(this, R.color.white_inactive))
        binding.btnSearch.setTextColor(ContextCompat.getColorStateList(this, R.color.white_inactive))
        binding.btnLibrary.setTextColor(ContextCompat.getColorStateList(this, R.color.white_inactive))
        binding.btnPremium.setTextColor(ContextCompat.getColorStateList(this, R.color.white_inactive))

        binding.btnHome.clearAnimation()
        binding.btnSearch.clearAnimation()
        binding.btnLibrary.clearAnimation()
        binding.btnPremium.clearAnimation()
    }

    override fun onBackStackChanged() {
        val currentFragment  = supportFragmentManager.findFragmentById(R.id.frag_container)

        when (currentFragment?.javaClass?.simpleName) {
            "HomeFragment" -> {
                change_btnState(binding.btnHome, R.drawable.icon_home_filled)
            }
            "SearchFragment" -> {
                change_btnState(binding.btnSearch, R.drawable.icon_search_filled)
            }
            "LibraryFragment" -> {
                change_btnState(binding.btnLibrary, R.drawable.icon_library_filled)
            }
            "PremiumFragment" -> {
                change_btnState(binding.btnPremium, R.drawable.icon_premium_filled)
            }
        }
    }
    fun updateTextViewText(songIndex: Int) {
        Picasso.get().load(viewModel.arrsongdis[songIndex].imgurl).into(binding.imgSong)
        binding.txtSongName.text = viewModel.arrsongdis[songIndex].name
        binding.txtSinger.text = viewModel.arrsongdis[songIndex].singers
        binding.txtSongName.isSelected = true;
        binding.txtSinger.isSelected = true;
    }


}
