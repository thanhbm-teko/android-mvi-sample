package vn.phongvu.android.nhanvienphongvu.listing.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import vn.phongvu.android.nhanvienphongvu.R
import vn.phongvu.android.nhanvienphongvu.databinding.ProductListFragmentBinding
import vn.phongvu.android.nhanvienphongvu.listing.business.ProductListViewModel
import vn.phongvu.android.nhanvienphongvu.listing.business.ProductListViewState
import vn.phongvu.android.nhanvienphongvu.listing.business.ProductListAction
import vn.phongvu.android.nhanvienphongvu.util.obtainViewModel
import kotlin.random.Random

class ProductListFragment : Fragment() {
    private lateinit var productListAdapter: ProductListAdapter

    companion object {
        const val TAG : String = "ProductListFragment"
    }

    private lateinit var mBinding: ProductListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.product_list_fragment, container, false)

        mBinding.apply {
            viewModel = obtainViewModel(ProductListViewModel::class.java)
        }

        mBinding.viewModel?.viewState?.observe(this, Observer {
            this.render(it)
        })

        productListAdapter = ProductListAdapter()
        mBinding.productsList.adapter = productListAdapter

        return mBinding.root
    }

    private fun render(state: ProductListViewState) {
        mBinding.isLoading = state.isLoading

        // Update Adapter
        productListAdapter.products = state.searchResponse.result.products
        productListAdapter.notifyDataSetChanged()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mBinding.productsSearchBtn.setOnClickListener {
            val query = mBinding.productsSearchBox.text.toString()

            val ran = Random.nextInt(2)
            when (ran.rem(2)) {
                0 -> mBinding.viewModel?.dispatch(ProductListAction.SearchProductAction(query))
                1 -> mBinding.viewModel?.dispatch(ProductListAction.DummyAction)
            }
        }
    }
}