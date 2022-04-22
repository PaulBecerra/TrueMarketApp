package com.profeco.trueconsumer.ui.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.adapter.MarketAdapter
import com.profeco.trueconsumer.adapter.MarketReviewAdapter
import com.profeco.trueconsumer.databinding.ActivityDetailMarketReviewBinding
import com.profeco.trueconsumer.model.Consumer
import com.profeco.trueconsumer.model.Market
import com.profeco.trueconsumer.model.MarketReview
import java.util.*
import kotlin.collections.ArrayList

class DetailMarketReviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMarketReviewBinding
    var marketReviewList: ArrayList<MarketReview> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMarketReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val market: Market = intent.extras?.getSerializable("market") as Market

        val imageView = binding.imageViewMarket
        imageView.setImageResource(market.image)

        val textViewMarketName = binding.textViewMarketName
        textViewMarketName.text = market.name

        val btnSendReview = binding.btnSendReview

        btnSendReview.setOnClickListener{
            val rating = binding.rating.rating

            val comment = binding.editTextComment.text

            if (comment.isEmpty()){
                Toast.makeText(baseContext, "Comment must not be empty",
                    Toast.LENGTH_SHORT).show()
            } else {
                // save review
            }
        }

        var recyclerViewMarket: RecyclerView = binding.recyclerView

        recyclerViewMarket.layoutManager = LinearLayoutManager(this)

        getMarketReviews()

        var adapter = MarketReviewAdapter(marketReviewList)
        recyclerViewMarket.adapter = adapter
    }

    private fun getMarketReviews(){
        val market1 = Market(1, "Walmart", R.drawable.walmart, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")

        val review1 = MarketReview(1, 5f, "excelente", 1, Consumer(1, "Juan", R.drawable.ic_baseline_person_24),  Date())
        val review2 = MarketReview(2, 4f, "regular", 1, Consumer(1, "Juan", R.drawable.ic_baseline_person_24),  Date())
        val review3 = MarketReview(3, 3f, "mas o menos", 1, Consumer(1, "Juan", R.drawable.ic_baseline_person_24),  Date())
        val review4 = MarketReview(4, 2f, "mal", 1, Consumer(1, "Juan", R.drawable.ic_baseline_person_24),  Date())
        val review5 = MarketReview(5, 1f, "pesimo", 1, Consumer(1, "Juan", R.drawable.ic_baseline_person_24),  Date())
        val review6 = MarketReview(6, 0f, "horrible", 1, Consumer(1, "Juan", R.drawable.ic_baseline_person_24),  Date())
        val review7 = MarketReview(7, 3.5f, "regular", 1, Consumer(1, "Juan", R.drawable.ic_baseline_person_24),  Date())

        marketReviewList.addAll(listOf(review1, review2, review3, review4, review5, review6, review7))
    }
}