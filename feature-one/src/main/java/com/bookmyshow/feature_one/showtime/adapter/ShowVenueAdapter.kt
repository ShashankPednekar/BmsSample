package com.bookmyshow.feature_one.showtime.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintProperties.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bookmyshow.feature_one.data.VenuesItem
import com.bookmyshow.feature_one.databinding.ItemFlowBinding
import com.bookmyshow.feature_one.databinding.ItemTimeBinding
import com.bookmyshow.feature_one.databinding.ItemVenueBinding
import javax.inject.Inject

class ShowVenueAdapter @Inject constructor() :
    RecyclerView.Adapter<ShowVenueAdapter.ShowDateAdapterViewHolder>() {
    var listener: ((VenuesItem, Int) -> Unit)? = null

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

            binding.clTiming.removeAllViews()

            val flowBinding = ItemFlowBinding.inflate(LayoutInflater.from(binding.root.context))
            binding.clTiming.addView(flowBinding.root)

            venuesItem.showTimes?.forEachIndexed { index, showtimesItem ->
                val timeBinding = ItemTimeBinding.inflate(LayoutInflater.from(binding.root.context))
                timeBinding.tvTime.text = showtimesItem.showTime

                val timeView = timeBinding.root
                timeView.layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                timeView.id = View.generateViewId()
                binding.clTiming.addView(timeView)
                flowBinding.root.addView(timeView)

                timeView.setOnClickListener { listener?.invoke(venuesItem, index) }
            }
        }
    }
}