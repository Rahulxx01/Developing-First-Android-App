package com.udacity.shoestore.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.ShowableListMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.viewmodel.AuthListener
import com.udacity.shoestore.ui.viewmodel.ShoesViewModel


class DetailShoeFragment : Fragment(),AuthListener {
    var navController: NavController? = null
    var shoeViewModel : ShoesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //  shoeViewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)
        shoeViewModel = activity?.run {
            ViewModelProviders.of(this)[ShoesViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : FragmentDetailShoeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_shoe,null,false)

        binding.viewmodel = shoeViewModel
        shoeViewModel?.authListener = this
        val view : View = binding.root

        return view
       // return inflater.inflate(R.layout.fragment_detail_shoe, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }



    override fun onStarted() {
            Toast.makeText(context,"Process Started",Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(response: LiveData<ArrayList<Shoe>>) {
        Toast.makeText(context,"Process Success",Toast.LENGTH_SHORT).show()

        navController!!.navigate(R.id.action_detailShoeFragment_to_shoeListScreenFragment)


    }

    override fun onFailure(message: String) {
        Toast.makeText(context,"Process Failure",Toast.LENGTH_SHORT).show()
    }

    override fun onCancel() {
        Toast.makeText(context,"Back to List Screen",Toast.LENGTH_SHORT).show()
        navController!!.navigate(R.id.action_detailShoeFragment_to_shoeListScreenFragment)
    }

    override fun displayData(shoeData: ArrayList<Shoe>) {

    }

    override fun navigation() {
        TODO("Not yet implemented")
    }


}
