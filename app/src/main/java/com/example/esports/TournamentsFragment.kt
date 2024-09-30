package com.example.esports

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esports.Adapters.TournamentsRecyclerAdapter
import com.example.esports.DataModels.TournamentsModel
import com.example.esports.FirebaseUtls.FirebaseRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TournamentsFragment : Fragment() {

private lateinit var recyclerView : RecyclerView
private lateinit var db : FirebaseFirestore
 private lateinit var  adapter : TournamentsRecyclerAdapter
private val tournamentDataList = mutableListOf<TournamentsModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        getTournamentData()

        var view = inflater.inflate(R.layout.fragment_tournaments, container, false)
        setUpRecyclerView(view ,tournamentDataList)
        return view
    }

    private fun getTournamentData() {
        val firestoreRepository = FirebaseRepository()
        lifecycleScope.launch {
            val data = firestoreRepository.getTournamentDataFromFirebase()
            tournamentDataList.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView(view : View,tournamentDataList: List<TournamentsModel>) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
         adapter = TournamentsRecyclerAdapter(requireContext(),tournamentDataList)
        recyclerView.adapter = adapter
    }


}