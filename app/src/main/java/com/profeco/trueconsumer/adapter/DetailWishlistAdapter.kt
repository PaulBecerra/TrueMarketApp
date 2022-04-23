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
import com.profeco.trueconsumer.model.MarketReview
import com.profeco.trueconsumer.model.Product
import com.profeco.trueconsumer.model.Wishlist

class DetailWishlistAdapter (private var productList: List<Product>):
    RecyclerView.Adapter<DetailWishlistAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        val image: ImageView
        val name: TextView
        val btnRemoveItem: Button

        init{
            image = itemView.findViewById(R.id.imageViewProductWishlist)
            name = itemView.findViewById(R.id.textViewProductNameWishlist)
            btnRemoveItem = itemView.findViewById(R.id.btnRemoveItemWishlist)
        }

    }

    // Create new views (invoked by the layout manager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_wishlist_product, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your marketList at this position and replace the
        // contents of the view with that element
        val product: Product = productList[position]
        holder.image.setImageResource(product.image)
        holder.name.text = product.name
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}