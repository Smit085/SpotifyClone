package com.example.spotifyclone

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerSongAdapter(
    private val context: Context,
    private val arrsongdis: ArrayList<SongCardModel>
) : RecyclerView.Adapter<RecyclerSongAdapter.ViewHolder>() {
    var itemClickListener: ItemClickListener? = null

    interface ItemClickListener {
        fun onItemClicked(imgurl: String,songname: String,singers: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_song: ImageView = itemView.findViewById(R.id.img_song)
        val txt_songName: TextView = itemView.findViewById(R.id.txt_songName)
        val txt_singer: TextView = itemView.findViewById(R.id.txt_singer)
        val txt_duration: TextView = itemView.findViewById(R.id.txt_duration)
        val txt_lyrics: TextView = itemView.findViewById(R.id.txt_lyrics)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(arrsongdis[position].imgurl).into(holder.img_song)
        holder.txt_songName.text = arrsongdis[position].name
        holder.txt_singer.text = arrsongdis[position].singers
        holder.txt_duration.text = arrsongdis[position].duration
        if (arrsongdis[position].lyrics) {
            holder.txt_lyrics.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener {
            Log.i("Hello",arrsongdis[position].name)
            itemClickListener?.onItemClicked(arrsongdis[position].imgurl,arrsongdis[position].name,arrsongdis[position].singers)
        }
    }

    override fun getItemCount(): Int {
        return arrsongdis.size
    }
}
