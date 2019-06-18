package vn.phongvu.android.nhanvienphongvu.services

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponse

interface ListingApi {
    @GET("/api/search/")
    fun searchAsync(@Query("channel") channel: String,
                      @Query("visitorId") visitorId: String,
                      @Query("q") q: String):
            Deferred<Response<SearchResponse>>

    @GET("api/search/")
    fun search(@Query("channel") channel: String,
               @Query("visitorId") visitorId: String,
               @Query("q") q: String):
            Call<SearchResponse>

    companion object {
        private const val BASE_URL = "<secret>"
        fun create(): ListingApi =
            create(HttpUrl.parse(BASE_URL)!!)
        private fun create(httpUrl: HttpUrl): ListingApi {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d("API", it)
            })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(ListingApi::class.java)
        }
    }
}