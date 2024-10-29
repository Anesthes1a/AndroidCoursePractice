package com.example.androidcoursepractice.presentation.mapper

import com.example.androidcoursepractice.domain.entity.ProductEntity
import com.example.androidcoursepractice.presentation.model.ProductUIModel

class ProductEntityToUIMapper {
    fun map(list: List<ProductEntity>) =
        list.map { ProductUIModel(
            id = it.id,
            title = it.title,
            price = it.price.toString(),
            category = it.category,
            description = it.description,
            image = it.image,
            rate = it.rating.rate.toString(),
            rateCount = it.rating.count.toString()
        ) }

    fun mapOne(entity: ProductEntity): ProductUIModel {
        return ProductUIModel(
            id = entity.id,
            title = entity.title,
            price = entity.price.toString(),
            category = entity.category,
            description = entity.description,
            image = entity.image,
            rate = entity.rating.rate.toString(),
            rateCount = entity.rating.count.toString()
        )
    }
}