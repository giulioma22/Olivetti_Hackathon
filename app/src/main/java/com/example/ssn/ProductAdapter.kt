package com.example.ssn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.products_layout.view.*

class ProductAdapter(private val list_of_products: List<ProductClass>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutview = LayoutInflater.from(parent.context).inflate(R.layout.products_layout, parent, false)
        return ViewHolder(layoutview)
    }

    override fun getItemCount() = list_of_products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val single_product = list_of_products[position]
        holder.view.infoProduct.text = "${single_product.productName} Expiration date: ${single_product.expirationDate}"
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    }

}
