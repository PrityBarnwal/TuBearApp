package com.coolapps.tubearhaiapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.coolapps.tubearhaiapp.model.BeerResponse
import com.coolapps.tubearhaiapp.model.BeerResponseItem
import com.coolapps.tubearhaiapp.repository.BeerPaging
import com.coolapps.tubearhaiapp.repository.BeerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(beerRepository: BeerRepository): ViewModel(){

    val beers: Flow<PagingData<BeerResponse<BeerResponseItem>>> = Pager(PagingConfig(pageSize = 20)) {
        BeerPaging(beerRepository)
    }.flow

}