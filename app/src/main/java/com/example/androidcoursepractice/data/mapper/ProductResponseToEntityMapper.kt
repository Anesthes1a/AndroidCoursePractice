package com.example.androidcoursepractice.data.mapper

import com.example.androidcoursepractice.data.model.ProductResponse
import com.example.androidcoursepractice.domain.entity.ProductEntity
import com.example.androidcoursepractice.domain.entity.RatingEntity

class ProductResponseToEntityMapper {

    fun map (response: List<ProductResponse>?): List<ProductEntity> {
        return response
            ?.map { mapOne(it) }
            .orEmpty()
    }

    fun mapOne(response: ProductResponse?): ProductEntity {
        return ProductEntity(
            id = response?.id ?: 0,
            title = response?.title ?: "Нет названия",
            price = response?.price ?: 0F,
            category = response?.category ?: "Нет категории",
            description = response?.description ?: "Нет описания",
            image = response?.image ?: "",
            rating = RatingEntity(
                rate = response?.rating?.rate ?: 0F,
                count = response?.rating?.count ?: 0
            )
        )
    }
}