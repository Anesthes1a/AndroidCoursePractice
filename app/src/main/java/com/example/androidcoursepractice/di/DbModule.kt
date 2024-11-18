package com.example.androidcoursepractice.di

import android.content.Context
import androidx.room.Room
import com.example.androidcoursepractice.data.db.ProductsDatabase
import org.koin.dsl.module

val dbModule = module {
    single { DataBaseBuilder.getInstance(get()) }
}

object DataBaseBuilder {
    private var INSTANCE: ProductsDatabase? = null

    fun getInstance(context: Context) :ProductsDatabase {
        if (INSTANCE == null){
            synchronized(ProductsDatabase::class){
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            ProductsDatabase::class.java,
            "ProductDB"
        ).build()
}