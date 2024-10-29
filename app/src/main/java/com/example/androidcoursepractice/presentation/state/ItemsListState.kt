package com.example.androidcoursepractice.presentation.state

import androidx.compose.runtime.Stable
import com.example.androidcoursepractice.presentation.model.ProductUIModel

@Stable
interface ItemsListState {
    val items: List<ProductUIModel>
    val error: String?
    val loading: Boolean
}