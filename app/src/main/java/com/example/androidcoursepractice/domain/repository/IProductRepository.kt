package com.example.androidcoursepractice.domain.repository

import com.example.androidcoursepractice.domain.entity.ProductEntity

interface IProductRepository {
    suspend fun getProducts(): List<ProductEntity>
    suspend fun getProductById(id: Int): ProductEntity
    suspend fun saveProduct(product: ProductEntity)
    suspend fun getSavedProducts(): List<ProductEntity>
    suspend fun deleteProduct(productId: Long)
}