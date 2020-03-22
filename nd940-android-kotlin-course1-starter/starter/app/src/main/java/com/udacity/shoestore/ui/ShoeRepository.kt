package com.udacity.shoestore.ui

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.models.Shoe

object ShoeRepository {


    
   fun getShoeData(shoeName : String , shoeSize : Double,shoeCompany : String,shoeDescription : String) : LiveData<ArrayList<Shoe>> {
       var shoeData : ArrayList<Shoe>?=null
       val response =  MutableLiveData<ArrayList<Shoe>>()
       shoeData!!.add(Shoe(shoeName,shoeSize,shoeCompany,shoeDescription))


       response.value = shoeData;
       return response

   }


}