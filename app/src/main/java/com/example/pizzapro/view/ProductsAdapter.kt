package com.example.pizzapro.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizzapro.R
import com.example.pizzapro.data.model.Product

class ProductsAdapter(private val context: Context, private val onProductClickListener: (Product) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private val products = mutableListOf<Product>()

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescriptionTextView)
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val productPriceTextView: TextView = itemView.findViewById(R.id.productPriceTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.productNameTextView.text = product.name
        holder.productDescriptionTextView.text = product.description
        Glide.with(context)
            .load(products[position])
            .placeholder(R.drawable.pizza)
            .into(holder.productImageView)
        holder.productPriceTextView.text ="От ${product.price} р"
        holder.productPriceTextView.setOnClickListener {
            onProductClickListener.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setListProducts(list: List<Product>){
        products.addAll(list)
        notifyDataSetChanged()
    }

}