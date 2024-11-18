package com.example.androidcoursepractice.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcoursepractice.domain.entity.ProductEntity
import com.example.androidcoursepractice.domain.repository.IProductRepository
import com.example.androidcoursepractice.launchLoadingAndError
import com.example.androidcoursepractice.presentation.mapper.ProductEntityToUIMapper
import com.example.androidcoursepractice.presentation.model.ProductUIModel
import com.example.androidcoursepractice.presentation.state.FavoriteListState
import com.example.androidcoursepractice.presentation.state.ItemsListState

class FavoriteProductsViewModel(
    private val repository: IProductRepository,
    private val mapper : ProductEntityToUIMapper
) : ViewModel() {
    private var products: List<ProductEntity> = emptyList()

    private val mutableState = MutableItemsListState()
    val viewState = mutableState as FavoriteListState

    init {
        loadProducts()
    }

    private fun loadProducts(){
        viewModelScope.launchLoadingAndError(
            handleError = { mutableState.error = it.localizedMessage },
            updateLoading = { mutableState.loading = it }
        ) {
            mutableState.items = emptyList()
            mutableState.error = null

            products = repository.getSavedProducts()
            mutableState.items = products.map { mapper.mapOne(it) }
        }
    }

    private class MutableItemsListState : FavoriteListState {
        override var items: List<ProductUIModel> by mutableStateOf(emptyList())
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
    }
}