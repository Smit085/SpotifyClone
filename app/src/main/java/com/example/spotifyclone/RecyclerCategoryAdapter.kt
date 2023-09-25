package com.example.spotifyclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerCategoryAdapter : RecyclerView.Adapter<RecyclerCategoryAdapter.ViewHolder> {

    private var context: Context
    var arrCatg = ArrayList<CategoryCardModel>()
    constructor(context: Context,arrCatg: ArrayList<CategoryCardModel>){
        this.context = context
        this.arrCatg = arrCatg
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_genre: TextView = itemView.findViewById(R.id.txt_genre)
        val img_genre: ImageView = itemView.findViewById(R.id.img_genre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.card_search_genre, parent, false)
         return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_genre.setText(arrCatg.get(position).catName)
        holder.img_genre.setImageResource(arrCatg.get(position).img)

    }

    override fun getItemCount(): Int {
         return arrCatg.size
    }
}
