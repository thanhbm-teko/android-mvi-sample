package vn.phongvu.android.nhanvienphongvu.listing.data.source

import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponse

interface ListingDataSource {
    suspend fun searchAsync(query: String) : SearchResponse?

    fun searchUseCallback(query: String, callback: (SearchResponse) -> Unit)
}