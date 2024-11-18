package com.example.androidcoursepractice.domain.entity

data class ProductEntity (
    val id: Long,
    val title: String,
    val price: Float,
    val category: String,
    val description: String,
    val image: String,
    val rating: RatingEntity
)