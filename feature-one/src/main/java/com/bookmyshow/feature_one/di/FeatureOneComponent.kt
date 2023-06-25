package com.bookmyshow.feature_one.di

import com.bookmyshow.common_ui.di.ViewModelBuilderModule
import com.bookmyshow.core.di.CoreComponent
import com.bookmyshow.feature_one.FeatureOneActivity
import com.bookmyshow.feature_one.showtime.ui.ShowDatesFragment
import dagger.Component

@Component(
    dependencies = [
        CoreComponent::class
    ],
    modules = [FeatureOneModule::class, FeatureOneViewModelModule::class, ViewModelBuilderModule::class]
)
interface FeatureOneComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): FeatureOneComponent
    }

    fun inject(activity: FeatureOneActivity)

    fun injectShowDatesFragment(showDatesFragment: ShowDatesFragment)
}