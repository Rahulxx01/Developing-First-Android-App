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

class LoginFragment : Fragment() ,View.OnClickListener{


    var navController : NavController ?= null

    companion object {
        fun newInstance() = LoginFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.newAccount_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.existingAccount_button).setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.newAccount_button -> {
                navController!!.popBackStack(R.id.loginFragment, true)
                navController!!.navigate(R.id.welcomeFragment)
            }


            R.id.existingAccount_button -> {
                navController!!.popBackStack(R.id.loginFragment, true)
                navController!!.navigate(R.id.welcomeFragment)
            }


        }
    }


}
