package com.example.spotifyclone

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

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
        val row_dailymix: LinearLayout = itemView.findViewById(R.id.row_dailymix)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_home_dailymix, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(arr_dailymix.get(position).name.isNotBlank()){
            holder.txt_name.text = arr_dailymix[position].description
        }
        if (arr_dailymix.get(position).imgurl.isNotBlank()) {
            Picasso.get().load(arr_dailymix[position].imgurl).into(holder.img_dailymix)
        }


        holder.row_dailymix.setOnClickListener { view ->
//            val intent = Intent(context, PlaylistFragment::class.java)

            Log.i("DESCRIPTION:",arr_dailymix[position].description)
//            Toast.makeText(context, "ID: "+arr_dailymix[position].id, Toast.LENGTH_LONG).show();
//            Toast.makeText(context, "DESCRIPTION: "+arr_dailymix[position].description, Toast.LENGTH_LONG).show();

            val id = arr_dailymix[position].id
            val description = arr_dailymix[position].description
        }

    }
    override fun getItemCount(): Int {
        return arr_dailymix.size
    }

}