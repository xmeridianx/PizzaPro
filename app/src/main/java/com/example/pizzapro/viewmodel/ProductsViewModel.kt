package com.example.pizzapro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzapro.data.model.Product
import com.example.pizzapro.data.repository.LocalRepositoryProducts
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {
    private val repository = LocalRepositoryProducts()


    private val _productsLiveData = MutableLiveData<List<Product>>()
    val productsLiveData: LiveData<List<Product>> get() = _productsLiveData

    fun loadProducts() {
        viewModelScope.launch {
            repository.getProductList().observeForever {
                _productsLiveData.postValue(it)
            }
        }
    }
}