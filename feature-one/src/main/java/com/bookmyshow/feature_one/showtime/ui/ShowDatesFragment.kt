package com.bookmyshow.feature_one.showtime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmyshow.feature_one.R
import com.bookmyshow.feature_one.databinding.FragmentShowDatesBinding
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import com.bookmyshow.feature_one.other.viewBinding
import com.bookmyshow.feature_one.showtime.adapter.ShowDateAdapter
import com.bookmyshow.feature_one.showtime.adapter.ShowVenueAdapter
import com.bookmyshow.feature_one.viewmodel.FeatureOneViewModel
import javax.inject.Inject


class ShowDatesFragment : Fragment() {
    private val binding by viewBinding(FragmentShowDatesBinding::bind)

    private lateinit var showDateAdapter: ShowDateAdapter
    private lateinit var showVenueAdapter: ShowVenueAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: FeatureOneViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureOneDaggerProvider.component.injectShowDatesFragment(this)
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
        observeViewModel()

        viewModel.fetchShowDetails()
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

    private fun observeViewModel() {
        viewModel.allVenueItems.observe(viewLifecycleOwner) {
            showDateAdapter.setData(it)
        }

        viewModel.selectedVenueItems.observe(viewLifecycleOwner) {
            showVenueAdapter.setData(it)
        }
    }
}