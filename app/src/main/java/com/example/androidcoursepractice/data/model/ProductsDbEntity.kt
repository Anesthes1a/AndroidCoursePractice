package com.example.androidcoursepractice.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_product")
class ProductsDbEntity (
    @PrimaryKey val id: Long? = null,
    @ColumnInfo(name = "productTitle") val title: String?,
    @ColumnInfo(name = "productPrice") val price: Float?,
    @ColumnInfo(name = "productCategory") val category: String?,
    @ColumnInfo(name = "productDescription") val description: String?,
    @ColumnInfo(name = "productImage") val image: String?,
    @ColumnInfo(name = "productRate") val rate: Float?,
    @ColumnInfo(name = "productRateCount") val rateCount: Int?
)