package com.example.pizzapro.view.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizzapro.R
import com.example.pizzapro.SingletonCart
import com.example.pizzapro.data.model.CartItem
import com.example.pizzapro.data.model.Product

class CartAdapter (private val context: Context) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val products = mutableListOf<CartItem>()

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescriptionTextView)
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val productAddButton: ImageButton = itemView.findViewById(R.id.buttonAddItem)
        val productDeleteButton: ImageButton = itemView.findViewById(R.id.buttonDeleteItem)
        val productQuantityTextView: TextView = itemView.findViewById(R.id.textViewQuantityItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item_product, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = products[position]
        if (product.product.name != null){
            holder.productNameTextView.text = product.product.name
            holder.productDescriptionTextView.text = product.product.description
            Glide.with(context)
                .load(products[position])
                .placeholder(R.drawable.pizza)
                .into(holder.productImageView)
            holder.productQuantityTextView.text = product.quantity.toString()
            holder.productAddButton.setOnClickListener {
                SingletonCart.addProduct(product.product)
            }
            holder.productDeleteButton.setOnClickListener {
                SingletonCart.deleteProduct(product.product)
            }
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setListProducts(list: MutableList<CartItem>){
        products.addAll(list)
        notifyDataSetChanged()
    }

}