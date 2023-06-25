package com.bookmyshow.feature_one.showtime.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintProperties.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bookmyshow.feature_one.data.VenuesItem
import com.bookmyshow.feature_one.databinding.ItemTimeBinding
import com.bookmyshow.feature_one.databinding.ItemVenueBinding

class ShowVenueAdapter(val listener: (VenuesItem) -> Unit) :
    RecyclerView.Adapter<ShowVenueAdapter.ShowDateAdapterViewHolder>() {

    private var venueList: List<VenuesItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowDateAdapterViewHolder {
        return ShowDateAdapterViewHolder(
            ItemVenueBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = venueList?.size ?: 0

    override fun onBindViewHolder(holder: ShowDateAdapterViewHolder, position: Int) {
        if (venueList != null) {
            holder.bindView(venueList?.get(position)!!)
        }
    }

    fun setData(venueList: List<VenuesItem>) {
        this.venueList = venueList
        notifyDataSetChanged()
    }

    inner class ShowDateAdapterViewHolder(private val binding: ItemVenueBinding) :
        ViewHolder(binding.root) {

        fun bindView(venuesItem: VenuesItem) {
            binding.tvTitle.text = venuesItem.name

            venuesItem.showTimes?.forEach { showtimesItem ->
                val timeBinding = ItemTimeBinding.inflate(LayoutInflater.from(binding.root.context))
                timeBinding.tvTime.text = showtimesItem.showTime

                val view = timeBinding.root
                view.layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                view.id = View.generateViewId()
                binding.root.addView(view)
                binding.flowTimings.addView(view)
            }
        }
    }
}