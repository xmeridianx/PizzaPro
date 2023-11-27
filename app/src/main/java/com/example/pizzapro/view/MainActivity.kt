package com.example.pizzapro.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.pizzapro.R
import com.example.pizzapro.databinding.ActivityMainBinding
import com.example.pizzapro.view.cart.CartFragment
import com.example.pizzapro.view.products.ProductsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.container, ProductsFragment())
            .commit()

        binding.bottomAppBar.setOnItemSelectedListener { menuItem -> itemSelected(menuItem) }
    }

    private fun itemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_home-> supportFragmentManager.beginTransaction().replace(R.id.container, ProductsFragment()).commit()
            R.id.menu_item_profile->  supportFragmentManager.beginTransaction().replace(R.id.container, ProfileFragment()).commit()
            R.id.menu_item_location ->  supportFragmentManager.beginTransaction().replace(R.id.container, LocationFragment()).commit()
            R.id.menu_item_cart ->  supportFragmentManager.beginTransaction().replace(R.id.container, CartFragment()).commit()
        }

        return true
    }
}