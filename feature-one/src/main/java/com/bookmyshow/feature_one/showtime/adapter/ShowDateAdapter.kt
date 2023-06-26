package com.bookmyshow.feature_one.showtime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bookmyshow.common_ui.getDayDateMonthFromDate
import com.bookmyshow.feature_one.data.VenuesItem
import com.bookmyshow.feature_one.databinding.ItemShowDateBinding

class ShowDateAdapter : RecyclerView.Adapter<ShowDateAdapter.ShowDateAdapterViewHolder>() {
    private var venueList: List<VenuesItem>? = null
    var listener: ((VenuesItem) -> Unit)? = null

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

    inner class ShowDateAdapterViewHolder(private val binding: ItemShowDateBinding) :
        ViewHolder(binding.root) {

        init {
            binding.llDate.setOnClickListener {
                if (venueList != null && adapterPosition != NO_POSITION) {
                    val selectedVenue = venueList!![adapterPosition]
                    listener?.invoke(selectedVenue)

                    venueList!!.forEach {
                        it.isSelected = it.name == selectedVenue.name
                    }
                    notifyDataSetChanged()
                }
            }
        }

        fun bindView(venuesItem: VenuesItem) {
            val (day, date, month) = getDayDateMonthFromDate(venuesItem.showDate)
            binding.tvDay.text = day
            binding.tvDate.text = date
            binding.tvMonth.text = month

            binding.llDate.isSelected = venuesItem.isSelected
            binding.tvDay.isSelected = venuesItem.isSelected
            binding.tvDate.isSelected = venuesItem.isSelected
            binding.tvMonth.isSelected = venuesItem.isSelected
        }
    }
}