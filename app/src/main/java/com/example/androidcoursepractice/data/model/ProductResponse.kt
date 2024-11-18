package com.example.androidcoursepractice.data.model

import com.google.errorprone.annotations.Keep

@Keep
class ProductResponse (
    val id: Long?,
    val title: String?,
    val price: Float?,
    val category: String?,
    val description: String?,
    val image: String?,
    val rating: RatingResponse?
)

@Keep
class RatingResponse (
    val rate: Float?,
    val count: Int?
)