package com.example.androidcoursepractice.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.androidcoursepractice.domain.entity.ProductEntity
import com.example.androidcoursepractice.domain.repository.IProductRepository
import com.example.androidcoursepractice.launchLoadingAndError
import com.example.androidcoursepractice.presentation.handlers.AllProductsScreenHandler
import com.example.androidcoursepractice.presentation.state.ItemsListState
import com.example.androidcoursepractice.presentation.mapper.ProductEntityToUIMapper
import com.example.androidcoursepractice.presentation.model.ProductUIModel
import com.example.androidcoursepractice.presentation.model.ScreenBarElements
import java.security.PrivateKey

class AllProductsViewModel(
    private val repository: IProductRepository,
    private val mapper : ProductEntityToUIMapper
): ViewModel() {

    private var products: List<ProductEntity> = emptyList()

    private val mutableState = MutableItemsListState()
    val viewState = mutableState as ItemsListState

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

            products = repository.getProducts()
            mutableState.items = products.map { mapper.mapOne(it) }
        }
    }

    private class MutableItemsListState : ItemsListState {
        override var items: List<ProductUIModel> by mutableStateOf(emptyList())
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
    }
}