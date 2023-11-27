package com.example.pizzapro.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pizzapro.data.model.Product

class LocalRepositoryProducts(): RepositoryProducts {

    override suspend fun getProductList(): LiveData<List<Product>> {
        val liveData = MutableLiveData<List<Product>>()

        val products = listOf(
            Product(1,"Мортаделла с песто", "Мортаделла, соус песто, моцарелла, кубики брынзы и фирменный томатный соус", "URL", 519),
            Product(2,"Пицца из половинок", "Соберите свою пиццу 35 см с двумя разными вкусами", "URL", 320),
            Product(3,"Сырная", "Моцарелла, сыры чеддер и пармезан, фирменный соус альфредо", "URL", 289),
            Product(4,"Пепперони фреш", "Пикантная пепперони, увеличенная порция моцареллы, томаты, фирменный томатный соус", "URL", 289)
        )
        liveData.value = products
        return liveData
    }


}