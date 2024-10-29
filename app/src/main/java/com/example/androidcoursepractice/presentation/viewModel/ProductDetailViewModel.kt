package com.example.androidcoursepractice.presentation.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcoursepractice.domain.repository.IProductRepository
import com.example.androidcoursepractice.launchLoadingAndError
import com.example.androidcoursepractice.presentation.mapper.ProductEntityToUIMapper
import com.example.androidcoursepractice.presentation.model.ProductUIModel
import com.example.androidcoursepractice.presentation.state.ItemState

class ProductDetailViewModel(
    private val repository: IProductRepository,
    private val mapper : ProductEntityToUIMapper
): ViewModel() {
    private val mutableState = MutableItemState()
    val viewState = mutableState as ItemState

    init {
        loadProducts()
    }

    private fun loadProducts(){
        viewModelScope.launchLoadingAndError(
            handleError = { mutableState.error = it.localizedMessage },
            updateLoading = { mutableState.loading = it }
        ) {
            mutableState.item = ProductUIModel()
            mutableState.error = null

            mutableState.item =
                mapper.mapOne(repository.getProductById(mutableState.id))
        }
    }

    fun setId(id: Int) {
        mutableState.id = id
        loadProducts()
    }

    private class MutableItemState : ItemState {
        override var item: ProductUIModel by mutableStateOf(ProductUIModel())
        override var id: Int by mutableStateOf(0)
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
    }
}