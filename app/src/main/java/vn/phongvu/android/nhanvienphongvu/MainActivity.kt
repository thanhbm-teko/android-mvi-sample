package vn.phongvu.android.nhanvienphongvu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vn.phongvu.android.nhanvienphongvu.listing.ui.ProductListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add product list fragment if this is first creation
        if (savedInstanceState == null) {
            val fragment = ProductListFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, ProductListFragment.TAG).commit()
        }


    }
}
