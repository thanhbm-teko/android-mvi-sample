package vn.phongvu.android.nhanvienphongvu.listing.business

import vn.phongvu.android.nhanvienphongvu.base.Action

sealed class ProductListAction : Action {
    data class SearchProductAction(val query: String?): ProductListAction()
    object DummyAction: ProductListAction()
}