package com.example.spotifyclone

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

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
        val cardview: CardView = itemView.findViewById(R.id.cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.card_search_genre, parent, false)
         return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(arrCatg.get(position).name.isNotBlank()){
            holder.txt_genre.text = arrCatg[position].name
        }
        if (arrCatg.get(position).imgurl.isNotBlank()) {
            Picasso.get().load(arrCatg[position].imgurl).into(holder.img_genre)
        }
        if (arrCatg[position].bg_color.isNotBlank()) {
            holder.cardview.backgroundTintList = ColorStateList.valueOf(Color.parseColor(arrCatg[position].bg_color))
        }

    }

    override fun getItemCount(): Int {
         return arrCatg.size
    }
}
