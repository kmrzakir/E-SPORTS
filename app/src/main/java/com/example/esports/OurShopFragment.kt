package com.example.esports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esports.Adapters.OurShopRecyclerAdapter
import com.example.esports.DataModels.OurShopModel

class OurShopFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_our_shop, container, false)
        val ourShopData1 = OurShopModel(R.drawable.free_fire_image,"new","Ultimate gaming PC","$900")
        val ourShopData2 = OurShopModel(R.drawable.pubg_image,"Popular","Xbox gaming controller","$700")
        val ourShopData3 = OurShopModel(R.drawable.call_of_duty_image,"new","Mechanical gaming keyboard","$40")
        val ourShopDataList : List<OurShopModel> = listOf(ourShopData1,ourShopData2,ourShopData3)
        setUpRecyclerView(view,ourShopDataList)
        return view
    }

    private fun setUpRecyclerView(view: View,ourShopDataList : List<OurShopModel>) {
      recyclerView = view.findViewById(R.id.ourShop_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapterrrr = OurShopRecyclerAdapter(requireContext(),ourShopDataList)
        recyclerView.adapter = adapterrrr
    }


}