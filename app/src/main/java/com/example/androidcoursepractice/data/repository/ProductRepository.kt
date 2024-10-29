package com.example.androidcoursepractice.data.repository

import com.example.androidcoursepractice.data.api.IProductApi
import com.example.androidcoursepractice.data.mapper.ProductResponseToEntityMapper
import com.example.androidcoursepractice.domain.entity.ProductEntity
import com.example.androidcoursepractice.domain.repository.IProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(
    private val api: IProductApi,
    private val mapper: ProductResponseToEntityMapper
) : IProductRepository {
    override suspend fun getProducts(): List<ProductEntity> {
        return withContext(Dispatchers.IO) {
            mapper.map(response = api.getProducts())
        }
    }

    override suspend fun getProductById(id: Int): ProductEntity {
        return withContext(Dispatchers.IO) {
            mapper.mapOne(response = api.getProductById(id))
        }
    }
}