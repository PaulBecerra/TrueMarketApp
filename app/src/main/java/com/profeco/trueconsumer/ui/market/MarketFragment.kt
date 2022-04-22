package com.profeco.trueconsumer.ui.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.profeco.trueconsumer.MarketAdapter
import com.profeco.trueconsumer.R
import com.profeco.trueconsumer.databinding.FragmentMarketBinding
import com.profeco.trueconsumer.model.Market

class MarketFragment : Fragment() {

    private var _binding: FragmentMarketBinding? = null
    var marketList: ArrayList<Market> = ArrayList()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMarketBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recyclerViewMarket: RecyclerView = binding.recyclerView

        recyclerViewMarket.layoutManager = LinearLayoutManager(activity)

        getMarkets()
        var adapter = MarketAdapter(marketList)
        recyclerViewMarket.adapter = adapter


        var searchView: SearchView = binding.searchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }

    private fun getMarkets(){
        val market1 = Market(1, "Walmart", R.drawable.walmart)
        val market2 = Market(2, "Soriana", R.drawable.walmart)
        val market3 = Market(3, "Costco", R.drawable.walmart)
        val market4 = Market(4, "Bodega Aurrera", R.drawable.walmart)
        val market5 = Market(5, "Sam's Club", R.drawable.walmart)
        val market6 = Market(6, "Ley", R.drawable.walmart)
        marketList.addAll(listOf(market1, market2, market3, market4, market5, market6))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}