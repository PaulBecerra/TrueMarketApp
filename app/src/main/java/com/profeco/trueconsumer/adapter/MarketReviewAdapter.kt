package com.profeco.trueconsumer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.model.MarketReview
import kotlin.collections.ArrayList

class MarketReviewAdapter(private var marketReviewList: ArrayList<MarketReview>):
    RecyclerView.Adapter<MarketReviewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        val image: ImageView
        val name: TextView
        val rating: RatingBar
        val comment: TextView
        val createdAt:TextView

        init{
            image = itemView.findViewById(R.id.imageViewConsumer)
            name = itemView.findViewById(R.id.textViewConsumerName)
            rating = itemView.findViewById(R.id.ratingReview)
            comment = itemView.findViewById(R.id.textViewComment)
            createdAt = itemView.findViewById(R.id.textViewDate)
        }

    }

    // Create new views (invoked by the layout manager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_review, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your marketList at this position and replace the
        // contents of the view with that element
        val marketReview: MarketReview = marketReviewList[position]
        holder.image.setImageResource(marketReview.consumer.image)
        holder.name.text = marketReview.consumer.name
        holder.rating.rating = marketReview.rating
        holder.comment.text = marketReview.comment
        holder.createdAt.text = marketReview.createdAt.toString()
    }

    override fun getItemCount(): Int {
        return marketReviewList.size
    }
}