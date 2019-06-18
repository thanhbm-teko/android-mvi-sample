package vn.phongvu.android.nhanvienphongvu

import org.junit.Test
import org.junit.Assert.*

import org.hamcrest.core.Is.`is`
import vn.phongvu.android.nhanvienphongvu.listing.helpers.PriceHelper


class PriceHelperTest {
    @Test fun test_PriceHelper_normal_input() {
        val priceStr = PriceHelper.formatPrice(0.0)
        assertThat(priceStr, `is`("0 đ"))
    }

    @Test (expected = IllegalArgumentException::class)
    fun test_PriceHelper_null() {
        PriceHelper.formatPrice(null)
    }
}
