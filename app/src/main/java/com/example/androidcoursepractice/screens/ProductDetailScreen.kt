package com.example.androidcoursepractice.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.androidcoursepractice.MainViewModel

@Composable
fun ProductDetailScreen(
    viewModel: MainViewModel,
    index: Int
){
    val product = viewModel.productsList[index]
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = product.title ?: "Нет названия",
                    fontSize = 36.sp
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(10.dp, 5.dp)
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                )
                Text(text = product.price.toString())
                Text(text = product.category)
                Text(text = product.description)
            }
        }
    }
}