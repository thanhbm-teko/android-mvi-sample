package vn.phongvu.android.nhanvienphongvu.listing.business

import androidx.lifecycle.*
import vn.phongvu.android.nhanvienphongvu.base.BaseViewModel

class ProductListViewModel(private val productListUseCase: ProductListUseCase) :
    BaseViewModel<ProductListViewState, ProductListAction, ProductListResult>() {
    override val internalViewState = ProductListViewState()

    override fun handle(action: ProductListAction) = liveData<ProductListResult> {
        when (action) {
            is ProductListAction.SearchProductAction -> productListUseCase.searchProduct(this, action.query)
            else -> emit(ProductListResult.ActionWrapper(action))
        }
    }

    override fun reduce(result: ProductListResult): ProductListViewState {
        return when (result) {
            is ProductListResult.Loading -> internalViewState.copy(isLoading = true)
            is ProductListResult.Success -> internalViewState.copy(
                isLoading = false,
                searchResponse = result.data,
                error = null
            )
            is ProductListResult.Failure -> internalViewState.copy(isLoading = false, error = null)
            is ProductListResult.ActionWrapper -> {
                when (result.action) {
                    is ProductListAction.DummyAction -> internalViewState.copy(isLoading = false, error = null)
                    else -> internalViewState
                }
            }
        }
    }
}