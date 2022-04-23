package com.profeco.trueconsumer.ui.wishlists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.adapter.MarketAdapter
import com.profeco.trueconsumer.adapter.WishlistAdapter
import com.profeco.trueconsumer.databinding.FragmentProductsBinding
import com.profeco.trueconsumer.databinding.FragmentWishlistBinding
import com.profeco.trueconsumer.model.*
import java.util.*
import kotlin.collections.ArrayList

class WishlistFragment : Fragment() {

    private var _binding: FragmentWishlistBinding? = null
    var wishlistList: ArrayList<Wishlist> = ArrayList()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recyclerViewMarket: RecyclerView = binding.recyclerView

        recyclerViewMarket.layoutManager = LinearLayoutManager(activity)

        getWishlists()
        var adapter = WishlistAdapter(wishlistList)
        recyclerViewMarket.adapter = adapter
    }

    private fun getWishlists(){
        val consumer = Consumer(1, "Juan", R.drawable.ic_baseline_person_24)

        val market1 = Market(2, "Soriana", R.drawable.walmart, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        val market2 = Market(3, "Costco", R.drawable.walmart, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")

        val product1 = Product(1, "Coca cola", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(
            MarketProduct(1, market1, 15f)
        ))
        val product2 = Product(2, "Big cola", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(
            MarketProduct(2, market1, 15f)
        ))
        val product3 = Product(3, "Pepsi", "Refresco carbonatizado", R.drawable.cocacola, Arrays.asList(
            MarketProduct(3, market1, 15f)
        ))

        val wishlist1 = Wishlist(1, consumer, market1, Arrays.asList(product1, product2, product3))
        val wishlist2 = Wishlist(2, consumer, market2, Arrays.asList(product1, product2, product3))


        wishlistList.addAll(listOf(wishlist1, wishlist2))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}