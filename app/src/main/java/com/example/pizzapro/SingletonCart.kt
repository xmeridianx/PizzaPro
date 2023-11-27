package com.example.pizzapro

import com.example.pizzapro.data.model.CartItem
import com.example.pizzapro.data.model.Product

object SingletonCart {
    private var productList = mutableListOf<CartItem>()

    fun addProduct(product: Product) {
        val existingProduct = productList.find { it.product.id == product.id }
        if (existingProduct == null) {
            val cartItem = CartItem(product, 1)
            productList.add(cartItem)
        } else {
            existingProduct.quantity ++
        }
    }

    fun deleteProduct(product: Product) {
        val productToDelete = productList.find { it.product.id == product.id }
        if (productToDelete != null ) {
            productToDelete.quantity--
            if (productToDelete.quantity == 0) {
                productList.remove(productToDelete)
            }
        }
    }

    fun getQuantity(id: Int): Int {
        if (productList.isEmpty()) {
            return 0
        }
        val product = productList?.find { it.product.id == id }
        return product?.quantity ?: 0
    }

    fun clear() {
        productList.clear()
    }

    fun getProductList(): MutableList<CartItem> {
        return productList
    }


}