package com.example.androidcoursepractice.data

import android.net.Uri
import com.example.androidcoursepractice.entity.Product
import com.example.androidcoursepractice.entity.Rating

// Апишка: https://fakestoreapi.com/products

class TestData {
    val products : List<Product> = generateSequence(1) { it + 1 }
        .map { index ->
            Product(
                id = index.toLong(),
                title = "Продукт - $index",
                price = 0f,
                category = "Мужская",
                description = "Ну типа описание. Вжух!",
                image = "https://fakestoreapi.com/img/81QpkIctqPL._AC_SX679_.jpg",
                rating = Rating(
                    rate = 5f,
                    count = 1
                )
            )
        }
        .take(10)
        .toList()
}