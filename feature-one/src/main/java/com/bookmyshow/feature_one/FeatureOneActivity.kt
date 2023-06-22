package com.bookmyshow.feature_one

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import com.bookmyshow.feature_one.viewmodel.FeatureOneViewModel
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: FeatureOneViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureOneDaggerProvider.component.inject(this)
        setContentView(R.layout.activity_feature_one)

        viewModel.test()
    }
}