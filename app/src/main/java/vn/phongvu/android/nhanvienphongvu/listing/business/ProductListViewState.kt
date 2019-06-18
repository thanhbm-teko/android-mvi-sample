package vn.phongvu.android.nhanvienphongvu.listing.business

import vn.phongvu.android.nhanvienphongvu.base.ViewState
import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponse
import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponseProducts

data class ProductListViewState(
    val isLoading: Boolean = false,
    val searchResponse: SearchResponse = SearchResponse(SearchResponseProducts(emptyArray()), ""),
    val error: Throwable? = null
) : ViewState