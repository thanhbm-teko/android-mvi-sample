package vn.phongvu.android.nhanvienphongvu.listing.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import vn.phongvu.android.nhanvienphongvu.R
import vn.phongvu.android.nhanvienphongvu.databinding.ListingProductComponentBinding
import vn.phongvu.android.nhanvienphongvu.listing.helpers.PriceHelper
import vn.phongvu.android.nhanvienphongvu.listing.helpers.StockCalculator
import vn.phongvu.android.nhanvienphongvu.listing.data.SearchResponseProductData


class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ListingViewHolder>() {
    var products: Array<SearchResponseProductData> = arrayOf()
    class ListingViewHolder(val listingBinding: ListingProductComponentBinding) : RecyclerView.ViewHolder(listingBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListingProductComponentBinding>(layoutInflater, R.layout.listing_product_component, parent, false)

        return ListingViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        holder.listingBinding.nameTxt.text = products[position].name
        holder.listingBinding.productPrice.text = PriceHelper.formatPrice(products[position].price.sellPrice)
        holder.listingBinding.skuTxt.text = """# ${products[position].sku}"""
        holder.listingBinding.stockTxt.text = StockCalculator.getProductStockText(products[position].stocks)
    }

    override fun getItemCount() = products.size
}