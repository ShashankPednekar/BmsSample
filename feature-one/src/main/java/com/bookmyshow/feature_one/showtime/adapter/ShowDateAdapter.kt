package com.bookmyshow.feature_one.showtime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bookmyshow.common_ui.getDayDateMonthFromDate
import com.bookmyshow.feature_one.data.VenuesItem
import com.bookmyshow.feature_one.databinding.ItemShowDateBinding

class ShowDateAdapter(val listener: (VenuesItem) -> Unit) :
    RecyclerView.Adapter<ShowDateAdapter.ShowDateAdapterViewHolder>() {
    private var venueList: List<VenuesItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowDateAdapterViewHolder {
        return ShowDateAdapterViewHolder(
            ItemShowDateBinding.inflate(
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

    inner class ShowDateAdapterViewHolder(val binding: ItemShowDateBinding) :
        ViewHolder(binding.root) {

        fun bindView(venuesItem: VenuesItem) {
            val (day, date, month) = getDayDateMonthFromDate(venuesItem.showDate)
            binding.tvDay.text = day
            binding.tvDate.text = date
            binding.tvMonth.text = month
        }
    }
}