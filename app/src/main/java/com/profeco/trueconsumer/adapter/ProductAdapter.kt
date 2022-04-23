package com.profeco.trueconsumer.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.ui.products.DetailProductActivity
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.model.Product
import java.util.*
import kotlin.collections.ArrayList

class ProductAdapter(private var productList: ArrayList<Product>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(), Filterable {

    var productFilterList = ArrayList<Product>()

    init {
        productFilterList = productList
    }
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        val image: ImageView
        val name: TextView

        init{
            image = itemView.findViewById(R.id.imageViewProductLayout)
            name = itemView.findViewById(R.id.textViewProductNameLayout)
        }

    }

    // Create new views (invoked by the layout manager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_product, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your productList at this position and replace the
        // contents of the view with that element
        val product: Product = productFilterList[position]
        holder.image.setImageResource(product.image)
        holder.name.text = product.name

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailProductActivity::class.java)
            intent.putExtra("product", product)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charSearch = p0.toString()
                if (charSearch.isEmpty()) {
                    productFilterList = productList
                } else {
                    val resultList = ArrayList<Product>()
                    for (product in productList) {
                        if (product.name.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(product)
                        }
                    }
                    productFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = productFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                productFilterList = p1?.values as ArrayList<Product>
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return productFilterList.size
    }
}