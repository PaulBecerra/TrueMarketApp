package com.profeco.trueconsumer.model

import java.io.Serializable

class Wishlist(val id: Int, val consumer: Consumer, val market:Market, val productList: List<Product>): Serializable {
}