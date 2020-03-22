package com.udacity.shoestore.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ShoesViewModel : ViewModel() {


    var shoeName: String? = null
    var shoeSize: String? = null
    var shoeDescription: String? = null
    var shoeCompany: String? = null
    var shoeData = ArrayList<Shoe>()

     var shoeLiveData : MutableLiveData<ArrayList<Shoe>>? = null

    var authListener: AuthListener? = null

    fun onSaveButton(view: View) {
        authListener?.onStarted()
        if (shoeName.isNullOrEmpty() && shoeSize.isNullOrEmpty() && shoeDescription.isNullOrEmpty() && shoeCompany.isNullOrEmpty()) {
            authListener?.onFailure("Please fill details correctly")
            return
        }
        val response =
            getShoeData(shoeName!!, shoeSize!!.toDouble(), shoeCompany!!, shoeDescription!!)
        //Success
        shoeCompany = "";
        shoeSize = ""
        shoeDescription = ""
        shoeName = ""


       authListener?.onSuccess(response)
    }



    fun getShoeData(shoeName: String, shoeSize: Double, shoeCompany: String, shoeDescription: String): LiveData<ArrayList<Shoe>> {

        val response = MutableLiveData<ArrayList<Shoe>>()
        shoeData.add(Shoe(shoeName, shoeSize, shoeCompany, shoeDescription))
        response.value = shoeData
        return response

    }
    fun onCancelButton(view: View) {
        authListener?.onCancel()
        //Success
    }

    fun onDisplayData():LiveData<ArrayList<Shoe>>{

        //authListener?.onStarted();
        val response = MutableLiveData<ArrayList<Shoe>>()
        response.value = shoeData
        return response

    }

    fun displayListData(): LiveData<ArrayList<Shoe>> {
        val response = onDisplayData()
        return response
       // authListener?.onSuccess(response)
       // shoeLiveData!!.value = shoeData
      //  return shoeLiveData as MutableLiveData<ArrayList<Shoe>>
    }



}