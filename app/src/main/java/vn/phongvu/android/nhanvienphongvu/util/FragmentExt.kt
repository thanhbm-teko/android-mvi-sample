package vn.phongvu.android.nhanvienphongvu.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import vn.phongvu.android.nhanvienphongvu.listing.ViewModelFactory
import vn.phongvu.android.nhanvienphongvu.listing.data.DefaultListingRepository
import vn.phongvu.android.nhanvienphongvu.listing.data.source.remote.ListingRemoteDataSource
import vn.phongvu.android.nhanvienphongvu.listing.business.ProductListUseCase

fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>): T {
    val listingRemoteDataSource = ListingRemoteDataSource()
    return ViewModelProviders.of(this, ViewModelFactory(
        ProductListUseCase(DefaultListingRepository(listingRemoteDataSource))
    )).get(viewModelClass)
}
