package vn.phongvu.android.nhanvienphongvu.listing.data.source.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vn.phongvu.android.nhanvienphongvu.services.ListingApi
import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponse
import vn.phongvu.android.nhanvienphongvu.listing.data.source.ListingDataSource

class ListingRemoteDataSource : ListingDataSource {
    private val api by lazy {
        ListingApi.create()
    }

    override suspend fun searchAsync(query: String) : SearchResponse? {
        val request = api.searchAsync("pv_online", "", query)
        val response = request.await()

        return response.body()
    }

    override fun searchUseCallback(query: String, callback: (SearchResponse) -> Unit) {
        api.search("pv_online", "", query).enqueue(object: Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                callback(response.body()!!)
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {

            }
        })
    }
}