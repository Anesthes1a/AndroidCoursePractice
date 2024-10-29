package com.example.androidcoursepractice.presentation.state

import androidx.compose.runtime.Stable
import com.example.androidcoursepractice.presentation.model.ProductUIModel

@Stable
interface ItemState {
    val item: ProductUIModel
    var id: Int
    val error: String?
    val loading: Boolean
}