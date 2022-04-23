package com.profeco.trueconsumer.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.ui.wishlists.DetailWishlistActivity
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.model.Wishlist

class WishlistAdapter (private var marketProductList: List<Wishlist>):
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        val image: ImageView
        val name: TextView


        init{
            image = itemView.findViewById(R.id.imageViewMarketWishlist)
            name = itemView.findViewById(R.id.textViewMarketWishlist)
        }

    }

    // Create new views (invoked by the layout manager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_wishlist, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your marketList at this position and replace the
        // contents of the view with that element
        val wishlist: Wishlist = marketProductList[position]
        holder.name.text = wishlist.market.name
        holder.image.setImageResource(wishlist.market.image)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailWishlistActivity::class.java)
            intent.putExtra("wishlist", wishlist)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return marketProductList.size
    }
}