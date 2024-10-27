package com.example.androidcoursepractice.entity

data class Product (
    val id: Long,
    val title: String,
    val price: Float,
    val category: String,
    val description: String,
    val image: String,
    val rating: Rating
)