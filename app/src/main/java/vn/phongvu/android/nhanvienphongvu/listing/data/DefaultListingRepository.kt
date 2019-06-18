package vn.phongvu.android.nhanvienphongvu.listing.data

import vn.phongvu.android.nhanvienphongvu.listing.ListingRepository
import vn.phongvu.android.nhanvienphongvu.listing.data.source.ListingDataSource

class DefaultListingRepository (
    private val listingRemoteDataSource: ListingDataSource
) : ListingRepository {

    override suspend fun searchAsync(query: String) : SearchResponse? {
        return listingRemoteDataSource.searchAsync(query)
    }

    override fun searchUseCallback(query: String, callback: (SearchResponse) -> Unit) {
        listingRemoteDataSource.searchUseCallback(query, callback)
    }
}