package com.udacity.shoestore.ui.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.udacity.shoestore.R


class WelcomeFragment : Fragment(),View.OnClickListener {

    var navController : NavController ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<ImageButton>(R.id.welcome_navigation_imageButton).setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.welcome_navigation_imageButton ->{
                navController!!.popBackStack(R.id.welcomeFragment, true)
                navController!!.navigate(R.id.instructionDestinationFragment)
            }



        }
    }




}
