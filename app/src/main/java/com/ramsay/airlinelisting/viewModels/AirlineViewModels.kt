package com.ramsay.airlinelisting.viewModels


import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ramsay.airlinelisting.repository.AirlinePagingSource

//@HiltViewModel
class AirlineViewModels :
    ViewModel() {

    fun getPageList() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                // maxSize = 70
            ),
            pagingSourceFactory = { AirlinePagingSource() }
        ).liveData
    }

