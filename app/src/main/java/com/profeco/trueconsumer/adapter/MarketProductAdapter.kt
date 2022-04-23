package com.profeco.trueconsumer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.model.MarketProduct
import com.profeco.trueconsumer.model.MarketReview

class MarketProductAdapter (private var marketProductList: List<MarketProduct>):
    RecyclerView.Adapter<MarketProductAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        val name: TextView
        val price: TextView
        val btnAddProductToWishlist: Button
        val btnReportProduct: Button


        init{
            name = itemView.findViewById(R.id.textViewMarketProduct)
            price = itemView.findViewById(R.id.textViewPrice)
            btnAddProductToWishlist = itemView.findViewById(R.id.btnAddToWishlist)
            btnReportProduct = itemView.findViewById(R.id.btnReportProduct)
        }

    }

    // Create new views (invoked by the layout manager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_market_product, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your marketList at this position and replace the
        // contents of the view with that element
        val marketProduct: MarketProduct = marketProductList[position]
        holder.name.text = "Seller:" + marketProduct.market.name
        holder.price.text = "Price: " + marketProduct.price.toString()
    }

    override fun getItemCount(): Int {
        return marketProductList.size
    }
}