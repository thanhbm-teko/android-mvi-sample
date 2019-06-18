package vn.phongvu.android.nhanvienphongvu.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vn.phongvu.android.nhanvienphongvu.listing.business.ProductListUseCase
import vn.phongvu.android.nhanvienphongvu.listing.business.ProductListViewModel

class ViewModelFactory constructor(
    private val productListUseCase: ProductListUseCase
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) = ProductListViewModel(
        productListUseCase
    ) as T
}