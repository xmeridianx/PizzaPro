package com.example.pizzapro.view.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzapro.SingletonCart
import com.example.pizzapro.data.model.Product
import com.example.pizzapro.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: CartAdapter
    private var totalPrice = 0.0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = CartAdapter(requireContext())
        binding.recyclerCart.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerCart.adapter = adapter

        val cartProducts = SingletonCart.getProductList()
        adapter.setListProducts(cartProducts)

        //updateTotalPrice()
        //binding.productPriceTextView.text = "Стоимость продуктов: $totalPrice"
    }

    private fun calculateTotalPrice(cart: MutableList<Product>): Double {
        totalPrice = 0.0
        for (product in cart) {
            totalPrice += product.price * product.quantity
        }
        return totalPrice
    }

    private fun updateTotalPrice() {
        val productList: MutableList<Product> =
            SingletonCart.getProductList() as MutableList<Product>
        totalPrice = calculateTotalPrice(productList)
        binding.totalPriceTextView.text = "Итого: ${"%.2f".format(totalPrice + 190)} Р"
    }

}