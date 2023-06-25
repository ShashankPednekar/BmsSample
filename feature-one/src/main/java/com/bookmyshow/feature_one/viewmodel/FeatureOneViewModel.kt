package com.bookmyshow.feature_one.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bookmyshow.feature_one.data.VenuesItem
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
class FeatureOneViewModel @Inject constructor(
    private val showTimesRepository: ShowTimesRepository
) : ViewModel() {
    private val TAG = "FeatureOneViewModel"

    private val _allVenueItems = MutableLiveData<List<VenuesItem>>()
    val allVenueItems: LiveData<List<VenuesItem>> = _allVenueItems

    private val _selectedVenueItems = MutableLiveData<List<VenuesItem>>()
    val selectedVenueItems: LiveData<List<VenuesItem>> = _selectedVenueItems

    private val venuesByDate = HashMap<String, List<VenuesItem>>()

    fun fetchShowDetails() {
        viewModelScope.launch {
            val response = showTimesRepository.fetchShowDetails()

            venuesByDate.clear()
            val venues = response.venues
            if (!response.venues.isNullOrEmpty()) {

                createVenuesByDates(venues!!)

                val firstVenue = venues[0]
                firstVenue.isSelected = true

                _allVenueItems.postValue(venues!!)

                updateVenueByDate(firstVenue)
            }
        }
    }

    fun updateVenueByDate(firstVenue: VenuesItem) {
        _selectedVenueItems.postValue(venuesByDate[firstVenue.showDate])
    }

    private fun createVenuesByDates(venues: List<VenuesItem>) {
        venues.forEach { venue ->
            val venuesList =
                venuesByDate[venue.showDate]?.toMutableList() ?: mutableListOf()

            venuesList.add(venue)

            venuesByDate[venue.showDate] = venuesList
        }
    }
}