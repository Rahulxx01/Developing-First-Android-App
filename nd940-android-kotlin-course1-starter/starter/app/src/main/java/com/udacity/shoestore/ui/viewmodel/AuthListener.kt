package com.udacity.shoestore.ui.viewmodel

import androidx.lifecycle.LiveData
import com.udacity.shoestore.models.Shoe

interface AuthListener {

    fun onStarted()
    fun onSuccess(response: LiveData<ArrayList<Shoe>>)
    fun onFailure(message:String)
    fun onCancel()
    fun displayData(shoeData: ArrayList<Shoe>)

    fun navigation()
}