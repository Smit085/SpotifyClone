package com.example.spotifyclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerRecentsAdapter: RecyclerView.Adapter<RecyclerRecentsAdapter.ViewHolder> {
    private var context: Context
    private var arr_recents = ArrayList<RecentsCardModel>()
    constructor(context: Context, arrsongdis: ArrayList<RecentsCardModel>){
        this.context = context
        this.arr_recents = arrsongdis
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_recents: ImageView = itemView.findViewById(R.id.img_recents)
        val txt_name: TextView = itemView.findViewById(R.id.txt_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_home_recents, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_recents.setImageResource(arr_recents.get(position).img)
        holder.txt_name.setText(arr_recents.get(position).name)
    }


    override fun getItemCount(): Int {
        return arr_recents.size
    }
}