package vn.phongvu.android.nhanvienphongvu.listing.data

import java.util.*

data class SearchResponse(val result: SearchResponseProducts, val code: String)

data class SearchResponseProducts(val products: Array<SearchResponseProductData>) {
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        return true
    }

    override fun hashCode(): Int{
        return Arrays.hashCode(products.map{
            it.hashCode()
        }.toIntArray())
    }
}

data class SearchResponseProductData(
    val sku: String,
    val displayName: String,
    val name: String,
    val price: SearchResponseProductDataPrice,
    val stocks: Array<SearchResponseProductStock>?
) {
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        return true
    }

    override fun hashCode(): Int{
        return sku.hashCode()
    }
}

data class SearchResponseProductDataPrice(val sellPrice: Double)

data class SearchResponseProductStock(
    val branch: String,
    val branchName: String,
    val warehouse: String,
    val warehouseName: String,
    val location: String,
    val storeCode: String?,
    val productBizType: String,
    val available: Double,
    val onHand: Double,
    val reserved: Double
)