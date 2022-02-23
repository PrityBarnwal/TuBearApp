package com.coolapps.tubearhaiapp.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.coolapps.tubearhaiapp.model.BeerResponse
import com.coolapps.tubearhaiapp.model.BeerResponseItem

class BeerPaging(private val beerRepository: BeerRepository) :PagingSource<Int, BeerResponse<BeerResponseItem>>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BeerResponse<BeerResponseItem>> {

        return try {
            val page = params.key?:1
            val response = beerRepository.getAllBeers(page, params.loadSize)
            LoadResult.Page(
               data = response,
                prevKey = if (page == 1) null
                else page - 1,
                nextKey = page.plus(1)
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }

    }

    @ExperimentalPagingApi
    override fun getRefreshKey(state: PagingState<Int, BeerResponse<BeerResponseItem>>): Int? {
        return null
    }

}