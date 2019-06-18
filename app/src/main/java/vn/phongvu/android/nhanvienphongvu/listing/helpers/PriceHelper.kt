package vn.phongvu.android.nhanvienphongvu.listing.helpers

import java.text.NumberFormat
import java.util.*


class PriceHelper  {
    companion object {
        private val currencyFormat : NumberFormat = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))

        fun formatPrice(price: Double?) : String {
            return currencyFormat.format(price)
        }
    }
}