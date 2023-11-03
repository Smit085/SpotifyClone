package com.example.spotifyclone

import android.app.Dialog
import android.app.Service
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.spotifyclone.databinding.ActivityMusicplayerBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import java.util.Timer
import java.util.TimerTask


class MusicPlayer : BottomSheetDialogFragment()  {
    private lateinit var binding: ActivityMusicplayerBinding
//    private var viewModel: DataViewModel by viewModels()
    private lateinit var mp: MediaPlayer
    private var playstate = false
    private val timer = Timer()
    private var songurl = ""
    var fav_state = false

    object DataRepository {
        var songName: String? = null
        var singers: String? = null
        var imgurl: String? = null
        var songurl: String? = null
    }
    override fun onStart() {
        super.onStart()

//        val dataTransferred = requireArguments().getBoolean("data_transferred", false)
//        if (dataTransferred) {
//            binding.txtSongname.text = requireArguments().getString("songname")
//        } else {
//            songurl="https://p.scdn.co/mp3-preview/b6ff84647cf7e8ea79d167ceeab786616a9e1c17?cid=d8a5ed958d274c2e8ee717e6a4b0971d"
//        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityMusicplayerBinding.inflate(inflater, container, false)
        binding.txtSongname.isSelected = true
        binding.txtSinger.isSelected = true

//        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
//        viewModel.selectedSongName.observe(this) { songName ->
//            binding.txtSongname.text = songName
//        }

        try {
            binding.txtSongname.text = DataRepository.songName
            songurl = DataRepository.songurl.toString()
            Picasso.get().load(DataRepository.imgurl).into(binding.imgSong)
            binding.txtSinger.text = DataRepository.singers
        }catch(e: Exception){
            Log.i("Error", e.message.toString())
            songurl="https://p.scdn.co/mp3-preview/b6ff84647cf7e8ea79d167ceeab786616a9e1c17?cid=d8a5ed958d274c2e8ee717e6a4b0971d"
//            songurl="https://i.scdn.co/image/ab67616d00001e029f27475f7c7ca4888c160c8c"
        }


        binding.btnPlaypause.setOnClickListener {
            if (playstate) {
                mp.pause()
                binding.btnPlaypause.setImageResource(R.drawable.baseline_play_circle_12)
                playstate = false
            } else {
                playSong(songurl)
            }
        }

        binding.seekSongbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    val songDuration = mp.duration
                    val newPosition = (progress * songDuration) / 100
                    mp.seekTo(newPosition)
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.btnFav.setOnClickListener {
            if (!fav_state) {
                binding.btnFav.setImageResource(R.drawable.icon_favourite_red)
                fav_state = true
            } else {
                binding.btnFav.setImageResource(R.drawable.icon_favourite)
                fav_state = false
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.isDraggable = false
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        val fadeInAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_fadein)
        binding.imgSong.startAnimation(fadeInAnimation)

        binding.btnBack.setOnClickListener {
            dismiss()
        }
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme).apply {
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.peekHeight = resources.displayMetrics.heightPixels
        }
    }

    private fun playSong(audioUrl: String) {
        try {
            mp = MediaPlayer()
            mp.setDataSource(audioUrl)
            mp.prepare()
            mp.start()
            mp.setOnCompletionListener {
                Log.d("MediaPlayer", "Playback completed.")
                binding.btnPlaypause.setImageResource(R.drawable.baseline_play_circle_12)
            }
            timer.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    val songDurationInMs = mp.duration
                    val songProgressInMs = mp.currentPosition
                    val songProgressPercentage = (songProgressInMs.toFloat() / songDurationInMs.toFloat()) * 100f
                    binding.seekSongbar.progress = songProgressPercentage.toInt()
                }
            }, 0, 800)

            binding.txtSongname.text = "Now Playing: $audioUrl"
            playstate = true
            binding.btnPlaypause.setImageResource(R.drawable.baseline_pause_circle_12)
        } catch (e: Exception) {
            Log.e("MediaPlayer", "Error: ${e.message}")
        }
    }

    fun updateplayer(songurl: String,imgurl: String, songname: String, singers: String) {
        // Update your TextView in MainActivity here


//        binding.txtSongname.text = songname
//        binding.txtSinger.text = singers
//        binding.txtSongname.isSelected = true;
//        binding.txtSinger.isSelected = true;
//        Picasso.get().load(songurl).into(binding.imgSong)
    }
    override fun onDestroy() {
        super.onDestroy()
//        mp.release()
        timer.cancel()
    }
}