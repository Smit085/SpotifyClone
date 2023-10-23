package com.example.spotifyclone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
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
        if(arr_dailymix.get(position).description.isNotBlank()){
            holder.txt_name.text = arr_dailymix[position].description
        }
        if (arr_dailymix.get(position).imgurl.isNotBlank()) {
            Picasso.get().load(arr_dailymix[position].imgurl).into(holder.img_dailymix)
        }

        holder.row_dailymix.setOnClickListener {

//            Toast.makeText(context, "", Toast.LENGTH_LONG).show();

            val playlistFragment = PlaylistFragment()
            val bundle = Bundle()
            bundle.putString("id", arr_dailymix[position].id)
            bundle.putString("description", arr_dailymix[position].description)
            bundle.putString("imgurl", arr_dailymix[position].imgurl)
            playlistFragment.arguments = bundle

            val fragmentManager = (context as MainActivity).supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frag_container, playlistFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
    override fun getItemCount(): Int {
        return arr_dailymix.size
    }

}