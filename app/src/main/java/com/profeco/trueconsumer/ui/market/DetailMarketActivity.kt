package com.profeco.trueconsumer.ui.market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.profeco.trueconsumer.databinding.ActivityDetailMarketBinding
import com.profeco.trueconsumer.model.Market

class DetailMarketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMarketBinding

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

        btnShowReviews.setOnClickListener{
            val intent = Intent(this, DetailMarketReviewActivity::class.java)
            intent.putExtra("market", market)
            startActivity(intent)
        }

    }
}