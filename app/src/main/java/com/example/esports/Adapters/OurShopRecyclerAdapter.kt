package com.example.esports.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.esports.DataModels.OurShopModel
import com.example.esports.R

class OurShopRecyclerAdapter(private val context : Context,private val ourShopDataList : List<OurShopModel>) : RecyclerView.Adapter<OurShopRecyclerAdapter.OurShopViewHolder>() {

    class OurShopViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView= itemView.findViewById(R.id.imageView)
        var labelTextView : TextView = itemView.findViewById(R.id.label_textView)
        var titleTextView : TextView = itemView.findViewById(R.id.title_textView)
        var priceTextView : TextView = itemView.findViewById(R.id.prize_textView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OurShopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.our_shop_recyclerview_item,parent,false)
        return OurShopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ourShopDataList.size
    }


    override fun onBindViewHolder(holder: OurShopViewHolder, position: Int) {
        Glide.with(context).load(ourShopDataList[position].ourShopImageUrl).into(holder.imageView)
        holder.labelTextView.text = ourShopDataList[position].label
        holder.titleTextView.text = ourShopDataList[position].title
        holder.priceTextView.text = ourShopDataList[position].price
    }

}