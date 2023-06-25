package com.bookmyshow.feature_one.showtime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmyshow.feature_one.R
import com.bookmyshow.feature_one.databinding.FragmentShowDatesBinding
import com.bookmyshow.feature_one.other.viewBinding
import com.bookmyshow.feature_one.showtime.adapter.ShowDateAdapter
import com.bookmyshow.feature_one.showtime.adapter.ShowVenueAdapter


class ShowDatesFragment : Fragment() {
    private val binding by viewBinding(FragmentShowDatesBinding::bind)

    private lateinit var showDateAdapter: ShowDateAdapter
    private lateinit var showVenueAdapter: ShowVenueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_dates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setShowDatesAdapter()
        setShowVenueAdapter()
    }

    private fun setShowDatesAdapter() {
        showDateAdapter = ShowDateAdapter {

        }
        binding.rvDates.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvDates.adapter = showDateAdapter
    }

    private fun setShowVenueAdapter() {
        showVenueAdapter = ShowVenueAdapter {

        }
        binding.rvVenues.layoutManager = LinearLayoutManager(context)
        binding.rvVenues.adapter = showVenueAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = ShowDatesFragment()
    }
}