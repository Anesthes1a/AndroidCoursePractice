package com.example.androidcoursepractice.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidcoursepractice.data.model.ProductsDbEntity

@Dao
interface ProductsDao {
    @Query("SELECT * FROM favorite_product")
    suspend fun getAll(): List<ProductsDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productDbEntity: ProductsDbEntity)

    @Query("DELETE FROM favorite_product WHERE id = :productId")
    suspend fun deleteProduct(productId: Long)
}