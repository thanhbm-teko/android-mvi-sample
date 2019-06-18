package vn.phongvu.android.nhanvienphongvu.listing.business

import androidx.lifecycle.LiveDataScope
import vn.phongvu.android.nhanvienphongvu.listing.data.DefaultListingRepository
import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponse
import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponseProducts

class ProductListUseCase(private val remoteListingRepository: DefaultListingRepository) {

    suspend fun searchProduct(scope: LiveDataScope<ProductListResult>, query: String?) {
        if (query != null) {
            scope.emit(ProductListResult.Loading)
            scope.emit(searchProductByApi(query))
        }
    }

    private suspend fun searchProductByApi(query: String): ProductListResult {
        try {
            var data = remoteListingRepository.searchAsync(query)
            data = data ?: SearchResponse(SearchResponseProducts(emptyArray()), "")
            return ProductListResult.Success(data)
        } catch (t: Throwable) {
            return ProductListResult.Failure(t.localizedMessage)
        }
    }
}