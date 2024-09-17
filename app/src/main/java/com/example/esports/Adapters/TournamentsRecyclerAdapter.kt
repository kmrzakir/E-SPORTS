package com.example.esports.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esports.DataModels.TournamentsModel
import com.example.esports.R

class TournamentsRecyclerAdapter(private val context : Context,private val tournamentDataList : List<TournamentsModel>) : RecyclerView.Adapter<TournamentsRecyclerAdapter.TournamentViewHolder>() {

      class TournamentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
          var imageView : ImageView = itemView.findViewById(R.id.tornaments_imageview)
          var titleTextView : TextView = itemView.findViewById(R.id.title_textView)
          var timeTextView : TextView = itemView.findViewById(R.id.time_textView)
          var playModeTextView : TextView = itemView.findViewById(R.id.playModeTextView)
          var platformTextView : TextView = itemView.findViewById(R.id.platformTextView)
          var prizeTextView : TextView = itemView.findViewById(R.id.prizeTextView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.tournaments_recyclerview_item,parent,false)
        return  TournamentViewHolder(view)
    }


    override fun getItemCount(): Int {
        return tournamentDataList.size
    }


    override fun onBindViewHolder(holder: TournamentViewHolder, position: Int) {
        holder.imageView.setImageResource(tournamentDataList[position].image)
        holder.titleTextView.text = tournamentDataList[position].title
        holder.timeTextView.text = tournamentDataList[position].time
        holder.playModeTextView.text = tournamentDataList[position].playMode
        holder.platformTextView.text = tournamentDataList[position].platform
        holder.prizeTextView.text = tournamentDataList[position].prize
    }


}