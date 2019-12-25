package com.example.mvvmbasicstrcture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /* private fun setProductsAdapter() {
        val list = listOf(
            ProductsBean("Apollo RHS Sofa", "Furniture", R.drawable.temp_proud),
            ProductsBean("65\" Smart Curved TV", "Automobile", R.drawable.temp_proud),
            ProductsBean("Unknown printer took", "Home Appliances", R.drawable.temp_proud),
            ProductsBean("Passages of Lorem", "Mobiles", R.drawable.temp_proud),
            ProductsBean("Standard chunk", "Furniture", R.drawable.temp_proud),
            ProductsBean("Sed ut perspiciatis ", "Home Appliances", R.drawable.temp_proud)
        )
        list_products.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        list_products.adapter = BindingAdapter(
            layoutId = R.layout.row_product,
            br = BR.product,
            list = ArrayList(list),
            clickListener = { view, position ->
                when (view.id) {
                    R.id.ll_product_root -> {
                        startActivity(ProductDetailActivity::class.java)
                    }
                }
            })
    }*/
}
