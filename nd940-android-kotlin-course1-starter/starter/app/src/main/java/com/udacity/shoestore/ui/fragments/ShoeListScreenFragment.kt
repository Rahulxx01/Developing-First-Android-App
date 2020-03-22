package com.udacity.shoestore.ui.fragments


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListScreenBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.viewmodel.AuthListener
import com.udacity.shoestore.ui.viewmodel.ShoesViewModel
import kotlinx.android.synthetic.main.fragment_shoe_list_screen.*



class ShoeListScreenFragment : Fragment(),View.OnClickListener,AuthListener{


    var navController : NavController ?= null
    var shoeViewModel  : ShoesViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : FragmentShoeListScreenBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list_screen,null,false)
        shoeViewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)
        binding.viewmodel = shoeViewModel
        shoeViewModel!!.authListener = this
        val view : View = binding.root





      return  view


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener(this)


        shoeViewModel = activity?.run {
            ViewModelProviders.of(this)[ShoesViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        shoeViewModel!!.displayListData().observe(viewLifecycleOwner, Observer {
            Toast.makeText(context,it.toString(),Toast.LENGTH_SHORT).show()

            if(it.size > 0){
                navController!!.popBackStack(R.id.detailShoeFragment, true)
                addShoesTextView.visibility = View.GONE
            }


            for(item in it){

                val textView = TextView(context)
                textView.text = item.name.toString() +"\n"+ item.company.toString()  +"\n"+ item.size.toString()  +"\n"+ item.description.toString()
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                textView.layoutParams = params
                params.setMargins(8,8,8,8)
                //Padding can be directly added to our views
                textView.setPadding(16, 16, 16, 16);

                textView.textSize = 20F
                textView.setTextColor(Color.BLACK)
                textView.setBackgroundColor(Color.parseColor("#9FA8DA"));

                showlistLinearLayout.addView(textView)
            }

        })


    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.fab -> navController!!.navigate(R.id.action_shoeListScreenFragment_to_detailShoeFragment)

        }
    }

    override fun onStarted() {

    }

    override fun onSuccess(response: LiveData<ArrayList<Shoe>>) {
        response.observe(this, Observer {
            Toast.makeText(context,it.toString(), Toast.LENGTH_SHORT).show()


        })

    }

    override fun onFailure(message: String) {

    }

    override fun onCancel() {

    }

    override fun displayData(shoeData: ArrayList<Shoe>) {


    }

    override fun navigation() {
        TODO("Not yet implemented")
    }


}
