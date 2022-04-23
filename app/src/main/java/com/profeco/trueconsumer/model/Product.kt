package com.profeco.trueconsumer.model

import java.io.Serializable

class Product(val id: Int, var name: String, val description: String, val image: Int, var marketProductList: List<MarketProduct> ): Serializable{
}