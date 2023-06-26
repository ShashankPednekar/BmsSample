package com.bookmyshow.feature_one.di

import com.bookmyshow.feature_one.showtime.adapter.ShowDateAdapter
import com.bookmyshow.feature_one.showtime.adapter.ShowVenueAdapter
import dagger.Module
import dagger.Provides

@Module
object FeatureOneModule {

    @Provides
    fun showDatesAdapter() = ShowDateAdapter()

    @Provides
    fun showVenueAdapter() = ShowVenueAdapter()
}