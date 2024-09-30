package com.example.esports.AndroidUtls

import android.content.Context
import android.widget.Toast

class AndroidUtlFunctions {

    companion object{
        fun showToast(context : Context,message : String){
            Toast.makeText(context,message,Toast.LENGTH_LONG).show();
        }
    }

}