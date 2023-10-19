package com.example.spotifyclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerDailymixAdapter: RecyclerView.Adapter<RecyclerDailymixAdapter.ViewHolder> {
    private var context: Context
    private var arr_dailymix = ArrayList<DailymixCardModel>()
    constructor(context: Context, arr_dailymix: ArrayList<DailymixCardModel>){
        this.context = context
        this.arr_dailymix = arr_dailymix
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_dailymix: ImageView = itemView.findViewById(R.id.img_dailymix)
        val txt_name: TextView = itemView.findViewById(R.id.txt_name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_home_dailymix, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img_dailymix.setImageResource(arr_dailymix.get(position).img)
        holder.txt_name.text = arr_dailymix[position].name
    }
    override fun getItemCount(): Int {
        return arr_dailymix.size
    }
}