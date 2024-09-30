package com.example.esports.FirebaseUtls

import com.example.esports.DataModels.OurShopModel
import com.example.esports.DataModels.TournamentsModel
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class FirebaseRepository {

    private var db = FirebaseFirestore.getInstance()

    suspend fun getTournamentDataFromFirebase(): List<TournamentsModel>{
        val tournamentDataList = mutableListOf<TournamentsModel>()
//        When you use await(), the coroutine waits for the Firebase query to complete before moving on to the next line of code.
//        This makes the code suspend until the data is fetched and ensures that you get the result before proceeding.
        val allDocuments = db.collection("TournamentsData").get().await()
        for(document in allDocuments){
            val tournament = document.toObject(TournamentsModel::class.java)
            tournamentDataList.add(tournament)
        }
        return tournamentDataList
    }

    suspend fun getOurShopDataFromFirebase() : List<OurShopModel>{
        val ourShopDataList = mutableListOf<OurShopModel>()
        val allDocuments = db.collection("OurShopData").get().await()
        for(document in allDocuments){
            val ourShop = document.toObject(OurShopModel::class.java)
            ourShopDataList.add(ourShop)
        }
        return ourShopDataList
    }
    companion object{
        fun getContactUsDataCollectionReference() : CollectionReference
        {
            return FirebaseFirestore.getInstance().collection("usersData")
        }
    }

}