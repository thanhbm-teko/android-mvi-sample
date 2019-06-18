package vn.phongvu.android.nhanvienphongvu.listing.helpers

import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponseProductStock

class StockCalculator {
    companion object {
        fun getProductStockText(stocks: Array<SearchResponseProductStock>?, branch: String = "CP09") : String {
            var available = 0
            var total = 0
            stocks?.forEach {
                if (it.branch == branch) available += it.available.toInt()
                total += it.available.toInt()
            }

            return """$available / $total"""
        }
    }
}