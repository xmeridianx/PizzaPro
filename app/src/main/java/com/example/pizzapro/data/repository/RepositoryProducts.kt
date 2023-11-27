package com.example.pizzapro.data.repository

import androidx.lifecycle.LiveData
import com.example.pizzapro.data.model.Product

interface RepositoryProducts {
    suspend fun getProductList(): LiveData<List<Product>>
}