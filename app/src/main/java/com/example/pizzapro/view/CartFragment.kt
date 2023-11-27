package com.example.pizzapro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.pizzapro.R
import com.example.pizzapro.databinding.FragmentCartBinding
import com.example.pizzapro.viewmodel.CartViewModel


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelCart = ViewModelProvider(requireActivity()).get(CartViewModel::class.java)
        adapter = ProductsAdapter(requireContext(), {it ->
            viewModelCart.addProduct(it)
        })


        binding.cartRecycler
    }


}