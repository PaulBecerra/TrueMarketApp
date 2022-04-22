package com.profeco.trueconsumer.model

import java.util.*

class MarketReview(val id: Int, var rating: Float, var comment: String, var marketId: Int, var consumer: Consumer, val createdAt: Date) {
}