package vn.phongvu.android.nhanvienphongvu.listing.business

import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponse
import vn.phongvu.android.nhanvienphongvu.base.Action
import vn.phongvu.android.nhanvienphongvu.base.Result

sealed class ProductListResult : Result {
    object Loading : ProductListResult()
    data class Success(val data: SearchResponse) : ProductListResult()
    data class Failure(val error: String) : ProductListResult()
    data class ActionWrapper(val action: Action): ProductListResult()
}