package com.example.esports.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.esports.AndroidUtls.AndroidUtlFunctions
import com.example.esports.DataModels.OurShopModel
import com.example.esports.FirebaseUtls.FirebaseRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    //firebase instance
    private var firebase = FirebaseFirestore.getInstance()

    // MutableLiveData for shop data
    private val _shopData = MutableLiveData<List<OurShopModel>>()
    val shopData: LiveData<List<OurShopModel>> get() = _shopData

    fun fetchShopData() {
        val firestoreRepository = FirebaseRepository()
        viewModelScope.launch {
            val data = firestoreRepository.getOurShopDataFromFirebase()
            _shopData.postValue(data)

        }
        fun addShopData() {

        }

    }
}