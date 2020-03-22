package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.udacity.shoestore.R

class InstructionDestinationFragment : Fragment() ,View.OnClickListener{
    var navController : NavController ?= null


    companion object {
        fun newInstance() =
            InstructionDestinationFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.instruction_destination_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.instructionButton).setOnClickListener(this)




    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.instructionButton -> {
                navController!!.popBackStack(R.id.instructionDestinationFragment,true)
                navController!!.navigate(R.id.shoeListScreenFragment)
            }

        }
    }




}
