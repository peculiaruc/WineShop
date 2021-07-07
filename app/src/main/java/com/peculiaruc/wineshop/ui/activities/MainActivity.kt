package com.peculiaruc.wineshop.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.databinding.ActivityMainBinding
import com.peculiaruc.wineshop.model.Drink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var  matcheddrinkLiveData = MutableLiveData<List<Drink>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.apply {
//            // show back button on toolbar
//            // on back button press, it will navigate to parent activity
//            setDisplayShowTitleEnabled(false)
//            setHomeAsUpIndicator(R.drawable.ic_arrow_back);
//            setDisplayHomeAsUpEnabled(true)
     //   }
    }
//    private fun performSearch() {
//        binding.searchWine.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                search(query)
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//               search(newText)
//                return true
//            }
//
//        } )
//    }
//
//    private fun search(text: String?) {
//      matcheddrinkLiveData = MutableLiveData()

//        text?.let {
//
//        }


 //   }

}