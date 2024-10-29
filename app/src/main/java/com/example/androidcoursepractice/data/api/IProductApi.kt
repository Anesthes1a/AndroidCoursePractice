package com.example.androidcoursepractice.data.api

import com.example.androidcoursepractice.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

// Апишка:
// https://fakestoreapi.com/products - все продукты
// https://fakestoreapi.com/products/{id} - продукт по id

interface IProductApi {
    @GET("products")
    suspend fun getProducts() : List<ProductResponse>?

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int,
    ) : ProductResponse?
}