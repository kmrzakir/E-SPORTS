package com.example.esports

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esports.Adapters.OurShopRecyclerAdapter
import com.example.esports.DataModels.OurShopModel
import com.example.esports.FirebaseUtls.FirebaseRepository
import com.example.esports.ViewModels.MyViewModel
import kotlinx.coroutines.launch

class OurShopFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var ourShopDataList = mutableListOf<OurShopModel>()
    private lateinit var adapter : OurShopRecyclerAdapter
    private lateinit var viewModel : MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initializing view model
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        //fetching data from view modal or we can say activating viewmodel
        viewModel.fetchShopData()

       //inflating fragment layout
        var view = inflater.inflate(R.layout.fragment_our_shop, container, false)

        // Setting up RecyclerView
        setUpRecyclerView(view)

        //observing view model data
        viewModel.shopData.observe(viewLifecycleOwner, Observer {
            ourShopDataList.clear()// Clear the list to avoid duplicates
            ourShopDataList.addAll(it)
           adapter.notifyDataSetChanged()// Notify the adapter of data changes
        })

        return view
    }

    //setting up recyclerview here
    private fun setUpRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.ourShop_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
         adapter = OurShopRecyclerAdapter(requireContext(), ourShopDataList)
        recyclerView.adapter = adapter
    }


}