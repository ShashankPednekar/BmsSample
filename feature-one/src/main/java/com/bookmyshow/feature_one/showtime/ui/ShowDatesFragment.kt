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


class ShowDatesFragment : Fragment() {
    private lateinit var showDateAdapter: ShowDateAdapter
    private val binding by viewBinding(FragmentShowDatesBinding::bind)

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
    }

    private fun setShowDatesAdapter() {
        showDateAdapter = ShowDateAdapter {

        }
        binding.rvDates.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvDates.adapter = showDateAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = ShowDatesFragment()
    }
}