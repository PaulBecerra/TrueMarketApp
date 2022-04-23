package com.profeco.trueconsumer.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.adapter.MarketAdapter
import com.profeco.trueconsumer.adapter.ProductAdapter
import com.profeco.trueconsumer.databinding.FragmentProductsBinding
import com.profeco.trueconsumer.model.Market
import com.profeco.trueconsumer.model.MarketProduct
import com.profeco.trueconsumer.model.Product
import java.util.*
import kotlin.collections.ArrayList

class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    var productList: ArrayList<Product> = ArrayList()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recyclerViewMarket: RecyclerView = binding.recyclerViewProduct

        recyclerViewMarket.layoutManager = LinearLayoutManager(activity)

        getProducts()
        var adapter = ProductAdapter(productList)
        recyclerViewMarket.adapter = adapter


        var searchView: SearchView = binding.searchViewProduct

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }

    private fun getProducts(){
        val market1 = Market(1, "Walmart", R.drawable.walmart, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        val market2 = Market(2, "Soriana", R.drawable.walmart, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        val market3 = Market(3, "Costco", R.drawable.walmart, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")

        val product1 = Product(1, "Coca cola", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(MarketProduct(1, market1, 15f), MarketProduct(1, market2, 10f), MarketProduct(1, market3, 18f)))
        val product2 = Product(2, "Big cola", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(MarketProduct(2, market1, 15f)))
        val product3 = Product(3, "Pepsi", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(MarketProduct(3, market1, 15f)))
        val product4 = Product(4, "Jarrito", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(MarketProduct(4, market1, 15f)))
        val product5 = Product(5, "Dr pepper", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(MarketProduct(5, market1, 15f)))
        val product6 = Product(6, "Jumex", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(MarketProduct(6, market1, 15f)))
        productList.addAll(listOf(product1, product2, product3, product4, product5, product6))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}