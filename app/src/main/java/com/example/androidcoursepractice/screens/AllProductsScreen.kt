package com.example.androidcoursepractice.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcoursepractice.handlers.AllProductsScreenHandler
import com.example.androidcoursepractice.MainViewModel
import com.example.androidcoursepractice.model.ScreenBarElements

@Composable
fun AllProductsScreen(
    viewModel: MainViewModel,
    handler: AllProductsScreenHandler
){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = ScreenBarElements.AllProducts.title ?: "Нет названия",
                    fontSize = 36.sp
                )
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(15.dp, 0.dp)
            ) {
                items(viewModel.productsList.size) { index: Int ->
                    val product = viewModel.productsList[index]
                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        onClick = {
                            handler.onToProductDetail(index)
                        }
                    ) {
                        Column {
                            Text(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                text = product.title,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}