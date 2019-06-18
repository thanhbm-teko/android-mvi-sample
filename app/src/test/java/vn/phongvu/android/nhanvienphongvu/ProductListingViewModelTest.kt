package vn.phongvu.android.nhanvienphongvu

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import vn.phongvu.android.nhanvienphongvu.listing.FakeListingRepository
import vn.phongvu.android.nhanvienphongvu.listing.ListingRepository

@RunWith(AndroidJUnit4::class)
class ProductListingViewModelTest {
    private lateinit var repository : ListingRepository

    @Before
    fun setupViewModel() {
        repository = FakeListingRepository()
    }

    @Test
    fun fakeRepository_searchAlwaysReturnNull() {
        runBlocking {
            val result = repository.searchAsync("")
            Truth.assertThat(result).isNull()
        }
    }
}