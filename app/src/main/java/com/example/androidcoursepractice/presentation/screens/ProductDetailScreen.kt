package com.example.androidcoursepractice.presentation.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.androidcoursepractice.presentation.viewModel.ProductDetailViewModel
import org.koin.androidx.compose.koinViewModel


class ProductDetailScreen(
    val id: Int = 0
) {
    @Composable
    fun Content(modifier: Modifier) {
        val viewModel = koinViewModel<ProductDetailViewModel>()
        viewModel.setId(id = id)
        val state = viewModel.viewState

        Surface(
            modifier = modifier
        ) {
            Scaffold(
                topBar = {
                    Text(
                        modifier = Modifier
                            .padding(12.dp),
                        text = state.item.title ?: "Нет названия",
                        fontSize = 36.sp
                    )
                }
            ) {
                    innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(10.dp, 5.dp)
                        .verticalScroll(ScrollState(0))
                ) {
                    AsyncImage(
                        model = state.item.image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 16.dp)
                            .height(480.dp)
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        text = "Цена: " + state.item.price + "$",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        text = "Категория: " + state.item.category,
                        fontSize = 22.sp
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        text = "Описание:\n" + state.item.description,
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}