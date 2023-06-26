package com.bookmyshow.feature_one.showtime.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bookmyshow.feature_one.FeatureOneActivity
import com.bookmyshow.feature_one.R
import com.bookmyshow.feature_one.databinding.FragmentShowTimeDetailsBinding
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import com.bookmyshow.feature_one.other.viewBinding
import com.bookmyshow.feature_one.viewmodel.FeatureOneViewModel
import javax.inject.Inject

class ShowTimeDetailsFragment : Fragment(R.layout.fragment_show_time_details) {
    private val binding by viewBinding(FragmentShowTimeDetailsBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: FeatureOneViewModel by viewModels({ activity as FeatureOneActivity }) { viewModelFactory }

    private var selectedUnique: String = ""
    private var selectedTimePos: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureOneDaggerProvider.component.injectShowTimeDetailsFragment(this)

        ShowTimeDetailsFragmentArgs.fromBundle(arguments ?: Bundle.EMPTY).let {
            selectedUnique = it.unique
            selectedTimePos = it.timePos
            viewModel.getSelectedShowDetails(it.unique)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.selectedVenue.observe(viewLifecycleOwner) {
            binding.tvName.text = it.name
            binding.tvTime.text = it.showTimes?.get(selectedTimePos)?.showTime ?: ""
        }
    }
}