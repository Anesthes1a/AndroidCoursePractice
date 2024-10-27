package com.example.androidcoursepractice.data

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.androidcoursepractice.entity.Product

class DataToStateMap {
    fun mapToProduct(data: TestData): SnapshotStateList<Product> {
        return data.products.toMutableStateList()
    }
}