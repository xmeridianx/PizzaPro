package com.example.pizzapro.data.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val price: Int,
    var quantity: Int = 0
)
