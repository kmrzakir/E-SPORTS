package com.example.esports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esports.Adapters.TournamentsRecyclerAdapter
import com.example.esports.DataModels.TournamentsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TournamentsFragment : Fragment() {

private lateinit var recyclerView : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val tournament1 = TournamentsModel(R.drawable.free_fire_image,"Free Fire ultimate challenge","20 Sept 2023 / 20:00 PM IST","1 V 1","Mobile","$600")
        val tournament2 = TournamentsModel(R.drawable.pubg_image,"PUBG Esports Championship","15 Sept 2023 / 20:00 PM IST","1 V 1","Mobile","$600")
        val tournament3 = TournamentsModel(R.drawable.call_of_duty_image,"CS:GO Global Gaming League","10 Sept 2023 / 14:00 PM IST","5 V 5","PC","$500")
        val tournamentDataList : List<TournamentsModel> = listOf(tournament1,tournament2,tournament3)


        var view = inflater.inflate(R.layout.fragment_tournaments, container, false)
        setUpRecyclerView(view ,tournamentDataList)
        return view
    }

    private fun setUpRecyclerView(view : View,tournamentDataList: List<TournamentsModel>) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TournamentsRecyclerAdapter(requireContext(),tournamentDataList)
        recyclerView.adapter = adapter
    }


}