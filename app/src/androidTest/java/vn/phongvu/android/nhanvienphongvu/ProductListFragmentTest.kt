package vn.phongvu.android.nhanvienphongvu

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.getIntents
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.common.truth.Truth.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import vn.phongvu.android.nhanvienphongvu.listing.ui.ProductListFragment


@RunWith(AndroidJUnit4::class)
class ProductListFragmentTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun searchButton_shouldDisplay() {
        // GIVEN
        launchFragmentInContainer<ProductListFragment>()

        // WHEN
        onView(withId(R.id.products_search_btn)).check(matches(isDisplayed()))
    }
}
