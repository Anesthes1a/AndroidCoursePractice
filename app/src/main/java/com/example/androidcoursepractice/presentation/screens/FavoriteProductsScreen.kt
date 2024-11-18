package com.example.androidcoursepractice.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcoursepractice.presentation.model.ScreenBarElements
import com.example.androidcoursepractice.presentation.viewModel.AllProductsViewModel
import com.example.androidcoursepractice.presentation.viewModel.FavoriteProductsViewModel
import org.koin.androidx.compose.koinViewModel


class FavoriteProductsScreen (

){
    @Composable
    fun Content(modifier: Modifier)
    {
        val viewModel = koinViewModel<FavoriteProductsViewModel>()
        val state = viewModel.viewState

        Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Scaffold(
                    topBar = {
                        Text(
                            modifier = Modifier
                                .padding(12.dp),
                            text = ScreenBarElements.FavouriteProducts.title ?: "Нет названия",
                            fontSize = 36.sp
                        )
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(12.dp, 0.dp)
                    ) {
                        items(state.items) { item ->
                            Card(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp, 10.dp)
                                    .height(100.dp),
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Text(
                                        modifier = Modifier
                                            .padding(12.dp),
                                        text = item.title,
                                        fontSize = 20.sp
                                    )
                                }
                            }
                        }
                    }
            }
        }
    }
}
