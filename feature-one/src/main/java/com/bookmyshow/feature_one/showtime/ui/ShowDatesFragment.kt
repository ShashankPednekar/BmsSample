package com.bookmyshow.feature_one.showtime.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmyshow.feature_one.FeatureOneActivity
import com.bookmyshow.feature_one.R
import com.bookmyshow.feature_one.databinding.FragmentShowDatesBinding
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import com.bookmyshow.feature_one.other.viewBinding
import com.bookmyshow.feature_one.showtime.adapter.ShowDateAdapter
import com.bookmyshow.feature_one.showtime.adapter.ShowVenueAdapter
import com.bookmyshow.feature_one.viewmodel.FeatureOneViewModel
import javax.inject.Inject


class ShowDatesFragment : Fragment(R.layout.fragment_show_dates) {
    private val TAG = "ShowDatesFragment"
    private val binding by viewBinding(FragmentShowDatesBinding::bind)

    @Inject
    lateinit var showDateAdapter: ShowDateAdapter

    @Inject
    lateinit var showVenueAdapter: ShowVenueAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: FeatureOneViewModel by viewModels({ activity as FeatureOneActivity }) { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureOneDaggerProvider.component.injectShowDatesFragment(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setShowDatesAdapter()
        setShowVenueAdapter()
        observeViewModel()

        viewModel.fetchShowDetails()
    }

    private fun setShowDatesAdapter() {
        showDateAdapter.listener = {
            viewModel.updateVenueByDate(it)
        }
        binding.rvDates.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvDates.adapter = showDateAdapter
    }

    private fun setShowVenueAdapter() {
        showVenueAdapter.listener = { venuesItem, pos ->
            Log.d(TAG, "setShowVenueAdapter: ${venuesItem.name} ${venuesItem.showTimes?.get(pos)}")
            if (activity != null) {
                val action = ShowDatesFragmentDirections.actionToShowTimeDetailsFragment(
                    venuesItem.name + venuesItem.showDate,
                    pos
                )
                findNavController().navigate(action)
            }
        }
        binding.rvVenues.layoutManager = LinearLayoutManager(context)
        binding.rvVenues.adapter = showVenueAdapter
    }

    private fun observeViewModel() {
        viewModel.allVenueItems.observe(viewLifecycleOwner) {
            showDateAdapter.setData(it)
        }

        viewModel.selectedVenueItems.observe(viewLifecycleOwner) {
            showVenueAdapter.setData(it)
        }
    }
}