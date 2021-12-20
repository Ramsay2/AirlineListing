package com.ramsay.airlinelisting.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramsay.airlinelisting.databinding.ActivityMainBinding
import com.ramsay.airlinelisting.models.response.Airline
import com.ramsay.airlinelisting.viewModels.AirlineViewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val airlineViewModel: AirlineViewModels by viewModels()
    private lateinit var airlineAdapter: AirlineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerview()
        getData()
    }

    private fun setRecyclerview() {
        airlineAdapter = AirlineAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = airlineAdapter
    }

    private fun getData() {
      /*  airlineViewModel.getData().observe(this, Observer {
            airlineAdapter.submitList(it as PagedList<Airline>?)
            airlineAdapter.notifyDataSetChanged()
        })*/
        airlineViewModel.getPageList().observe(this, Observer {
            CoroutineScope(Dispatchers.Main).launch {
                airlineAdapter.submitData(it)
                airlineAdapter.notifyDataSetChanged()
            }

    })
}
}
