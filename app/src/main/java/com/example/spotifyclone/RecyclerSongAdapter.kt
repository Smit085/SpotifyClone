package com.example.spotifyclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerSongAdapter: RecyclerView.Adapter<RecyclerSongAdapter.ViewHolder> {

    private var context: Context
    private var arrsongdis = ArrayList<SongCardModel>()
    constructor(context: Context, arrsongdis: ArrayList<SongCardModel>){
        this.context = context
        this.arrsongdis = arrsongdis
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_song: ImageView = itemView.findViewById(R.id.img_song)
        val txt_songName: TextView = itemView.findViewById(R.id.txt_songName)
        val txt_singer: TextView = itemView.findViewById(R.id.txt_singer)
        val txt_lyrics: TextView = itemView.findViewById(R.id.txt_lyrics)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_song.setImageResource(arrsongdis.get(position).songImage)
        holder.txt_songName.setText(arrsongdis.get(position).songName)
        holder.txt_singer.setText(arrsongdis.get(position).singerName)
        if(arrsongdis.get(position).lyrics == true){
            holder.txt_lyrics.visibility = View.VISIBLE
        }
    }


    override fun getItemCount(): Int {
        return arrsongdis.size
    }
}