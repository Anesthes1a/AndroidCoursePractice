package com.example.androidcoursepractice.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidcoursepractice.data.dao.ProductsDao
import com.example.androidcoursepractice.data.model.ProductsDbEntity

@Database(entities = [ProductsDbEntity::class], version = 1)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}