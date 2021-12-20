package com.ramsay.airlinelisting.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramsay.airlinelisting.R
import com.ramsay.airlinelisting.databinding.ItemLayoutBinding
import com.ramsay.airlinelisting.models.response.Airline
import com.ramsay.airlinelisting.models.response.Data

class AirlineAdapter : PagingDataAdapter<Data, AirlineAdapter.AirlineViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AirlineAdapter.AirlineViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_layout, parent, false)
        return AirlineViewHolder(layoutBinding)
    }

    override fun onBindViewHolder(holder: AirlineAdapter.AirlineViewHolder, position: Int) {
        val airline = getItem(position)
        if (airline != null) {
            val itr = airline.airline.listIterator()
           while (itr.hasNext()){
               holder.getData(itr.next())
           }

        }
    }

    inner class AirlineViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun getData(airline: Airline) {
            binding.airline = airline
            Glide.with(binding.ivLogo)
                .load(airline.logo).into(binding.ivLogo)
        }
    }
}