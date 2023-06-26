package com.bookmyshow.feature_one.showtime.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bookmyshow.feature_one.R
import com.bookmyshow.feature_one.databinding.FragmentShowTimeDetailsBinding
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import com.bookmyshow.feature_one.other.viewBinding

class ShowTimeDetailsFragment : Fragment(R.layout.fragment_show_time_details) {
    private val binding by viewBinding(FragmentShowTimeDetailsBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureOneDaggerProvider.component.injectShowTimeDetailsFragment(this)
    }
}