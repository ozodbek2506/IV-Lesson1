package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(context:Context, var items:MutableList<ItemData>):RecyclerView.Adapter<ItemAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val item_background: ImageView=itemView.findViewById(R.id.background_img)
        val item_name:TextView=itemView.findViewById(R.id.name)
        var item_recepies:TextView=itemView.findViewById(R.id.recepies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=items[position]
        holder.item_background.setImageResource(currentItem.background_img)
        holder.item_name.text=currentItem.name
        holder.item_recepies.text=currentItem.recepies
    }

}