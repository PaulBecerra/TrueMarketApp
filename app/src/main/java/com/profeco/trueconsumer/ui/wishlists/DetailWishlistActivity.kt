package com.profeco.trueconsumer.ui.wishlists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.adapter.DetailWishlistAdapter
import com.profeco.trueconsumer.adapter.MarketReviewAdapter
import com.profeco.trueconsumer.adapter.ProductAdapter
import com.profeco.trueconsumer.databinding.ActivityDetailWishlistBinding
import com.profeco.trueconsumer.model.Product
import com.profeco.trueconsumer.model.Wishlist

class DetailWishlistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailWishlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailWishlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wishlist: Wishlist = intent.extras?.getSerializable("wishlist") as Wishlist

        val textViewSeller = binding.textViewSeller

        textViewSeller.text = wishlist.market.name

        var recyclerViewMarket: RecyclerView = binding.recyclerViewProduct

        recyclerViewMarket.layoutManager = LinearLayoutManager(this)

        var adapter = DetailWishlistAdapter(wishlist.productList)
        recyclerViewMarket.adapter = adapter

    }
}