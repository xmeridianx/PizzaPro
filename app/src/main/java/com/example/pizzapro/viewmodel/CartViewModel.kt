package com.example.pizzapro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzapro.data.model.CartItem
import com.example.pizzapro.data.model.Product

class CartViewModel: ViewModel() {
    private val _cartItems = MutableLiveData<MutableList<Product>>()
    val cartItems: LiveData<MutableList<Product>> get() = _cartItems

    init {
        _cartItems.value = mutableListOf()
    }

    fun addProduct(product: Product) {
        _cartItems.value?.add(product)
        _cartItems.postValue(_cartItems.value)
    }

    fun removeProduct(product: Product) {
        _cartItems.value?.remove(product)
        _cartItems.postValue(_cartItems.value)
    }
}