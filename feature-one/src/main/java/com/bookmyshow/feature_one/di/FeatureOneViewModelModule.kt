package com.bookmyshow.feature_one.di

import androidx.lifecycle.ViewModel
import com.bookmyshow.common_ui.di.ViewModelKey
import com.bookmyshow.feature_one.viewmodel.FeatureOneViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FeatureOneViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FeatureOneViewModel::class)
    abstract fun bindViewModel(viewModel: FeatureOneViewModel): ViewModel
}