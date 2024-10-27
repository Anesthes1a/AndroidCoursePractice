package com.example.androidcoursepractice

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.androidcoursepractice.data.DataToStateMap
import com.example.androidcoursepractice.data.TestData
import com.example.androidcoursepractice.entity.Product

class MainViewModel: ViewModel() {
    private val products = DataToStateMap().mapToProduct(TestData())

    val productsList: SnapshotStateList<Product> get() = products
}