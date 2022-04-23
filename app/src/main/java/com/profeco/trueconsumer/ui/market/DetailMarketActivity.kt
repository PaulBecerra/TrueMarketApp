package com.profeco.trueconsumer.ui.market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.adapter.ProductAdapter
import com.profeco.trueconsumer.databinding.ActivityDetailMarketBinding
import com.profeco.trueconsumer.model.Market
import com.profeco.trueconsumer.model.MarketProduct
import com.profeco.trueconsumer.model.Product
import java.util.*

class DetailMarketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMarketBinding
    var productList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val market: Market = intent.extras?.getSerializable("market") as Market

        val imageViewMarket = binding.imageViewMarket

        val textViewMarket = binding.textViewMarket

        imageViewMarket.setImageResource(market.image)
        textViewMarket.text = market.name

        val btnShowReviews = binding.btnShowReviews

        btnShowReviews.setOnClickListener {
            val intent = Intent(this, DetailMarketReviewActivity::class.java)
            intent.putExtra("market", market)
            startActivity(intent)
        }

        var recyclerViewMarket: RecyclerView = binding.recyclerView

        recyclerViewMarket.layoutManager = LinearLayoutManager(this)

        getProductsByMarket();

        var adapter = ProductAdapter(productList)
        recyclerViewMarket.adapter = adapter


        var searchView: SearchView = binding.searchView

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

    private fun getProductsByMarket(){
        val market1 = Market(1, "Walmart", R.drawable.walmart, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")

        val product1 = Product(1, "Coca cola", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(
            MarketProduct(1, market1, 15f)))
        val product2 = Product(2, "Big cola", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(
            MarketProduct(2, market1, 15f)))
        val product3 = Product(3, "Pepsi", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(
            MarketProduct(3, market1, 15f)))

        productList.addAll(listOf(product1, product2, product3))
    }
}