package vn.phongvu.android.nhanvienphongvu.listing

import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponse

interface ListingRepository {
    suspend fun searchAsync(query: String) : SearchResponse?

    fun searchUseCallback(query: String, callback: (SearchResponse) -> Unit)
}