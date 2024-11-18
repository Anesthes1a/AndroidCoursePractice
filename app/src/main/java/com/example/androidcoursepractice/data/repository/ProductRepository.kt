package com.example.androidcoursepractice.data.repository

import com.example.androidcoursepractice.data.api.IProductApi
import com.example.androidcoursepractice.data.db.ProductsDatabase
import com.example.androidcoursepractice.data.mapper.ProductResponseToEntityMapper
import com.example.androidcoursepractice.data.model.ProductsDbEntity
import com.example.androidcoursepractice.domain.entity.ProductEntity
import com.example.androidcoursepractice.domain.entity.RatingEntity
import com.example.androidcoursepractice.domain.repository.IProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(
    private val api: IProductApi,
    private val productDb: ProductsDatabase,
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

    override suspend fun saveProduct(product: ProductEntity) {
        return withContext(Dispatchers.IO) {
            productDb.productsDao().insertProduct(
                ProductsDbEntity(
                    id = product.id,
                    title = product.title,
                    price = product.price,
                    category = product.category,
                    description = product.description,
                    image = product.image,
                    rate = product.rating.rate,
                    rateCount = product.rating.count
                )
            )
        }
    }

    override suspend fun getSavedProducts(): List<ProductEntity> {
        return withContext(Dispatchers.IO){
            productDb.productsDao().getAll().map {
                ProductEntity(
                    id = it.id ?: 0L,
                    title = it.title.orEmpty(),
                    price = it.price ?: 0F,
                    category = it.category.orEmpty(),
                    description = it.description.orEmpty(),
                    image = it.image.orEmpty(),
                    rating = RatingEntity(
                        rate = it.rate ?: 0F,
                        count = it.rateCount ?: 0,
                    )
                )
            }
        }
    }

    override suspend fun deleteProduct(productId: Long) {
        return withContext(Dispatchers.IO){
            productDb.productsDao().deleteProduct(productId)
        }
    }
}