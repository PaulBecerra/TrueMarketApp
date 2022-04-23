package com.profeco.trueconsumer.ui.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.adapter.MarketProductAdapter
import com.profeco.trueconsumer.adapter.ProductAdapter
import com.profeco.trueconsumer.databinding.ActivityDetailProductBinding
import com.profeco.trueconsumer.model.Market
import com.profeco.trueconsumer.model.Product

class DetailProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailProductBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val product: Product = intent.extras?.getSerializable("product") as Product

        val imageView = binding.imageView

        imageView.setImageResource(product.image)

        val textViewProductName = binding.textViewProduct

        textViewProductName.text = product.name

        val textViewDescription = binding.textViewProductDescription
        textViewDescription.text = product.description

        var recyclerViewMarket: RecyclerView = binding.recyclerView

        recyclerViewMarket.layoutManager = LinearLayoutManager(this)

        var adapter = MarketProductAdapter(product.marketProductList)
        recyclerViewMarket.adapter = adapter
    }
}