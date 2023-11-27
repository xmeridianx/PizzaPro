package com.example.pizzapro.view.products

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzapro.R
import com.example.pizzapro.SingletonCart
import com.example.pizzapro.databinding.FragmentCategoriesBinding
import com.example.pizzapro.viewmodel.ProductsViewModel


class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var adapter: ProductsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductsAdapter(requireContext(), {it ->
            SingletonCart.addProduct(it)
            showAddedToCartMessage()
        })

        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewProducts.adapter = adapter

        val viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

        viewModel.productsLiveData.observe(viewLifecycleOwner) { it ->
                adapter.setListProducts(it)
        }
        viewModel.loadProducts()
    }

    private fun showAddedToCartMessage() {
        Toast.makeText(context, "Добавлено", Toast.LENGTH_SHORT).show()
    }
}