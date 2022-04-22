package com.profeco.trueconsumer

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.model.Market
import java.util.*
import kotlin.collections.ArrayList

class MarketAdapter(private var marketList: ArrayList<Market>):
    RecyclerView.Adapter<MarketAdapter.ViewHolder>(), Filterable {

    var marketFilterList = ArrayList<Market>()

    init {
        marketFilterList = marketList
    }
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        val image: ImageView
        val name: TextView

        init{
            image = itemView.findViewById(R.id.imageViewMarket)
            name = itemView.findViewById(R.id.textViewMarket)
        }

    }

    // Create new views (invoked by the layout manager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_market, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your marketList at this position and replace the
        // contents of the view with that element
        val market: Market = marketFilterList[position]
        holder.image.setImageResource(market.image)
        holder.name.text = market.name

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailMarketActivity::class.java)
            intent.putExtra("market", market)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charSearch = p0.toString()
                if (charSearch.isEmpty()) {
                    marketFilterList = marketList
                } else {
                    val resultList = ArrayList<Market>()
                    for (market in marketList) {
                        if (market.name.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(market)
                        }
                    }
                    marketFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = marketFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                marketFilterList = p1?.values as ArrayList<Market>
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return marketFilterList.size
    }
}