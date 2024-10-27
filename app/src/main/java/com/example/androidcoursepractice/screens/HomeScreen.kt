package com.example.androidcoursepractice.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcoursepractice.MainViewModel
import com.example.androidcoursepractice.model.ScreenBarElements

@Composable
fun HomeScreen(
    viewModel: MainViewModel
){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = ScreenBarElements.Home.title ?: "Нет названия",
                    fontSize = 36.sp
                )
            }
        ) { innerPadding ->
            Text(
                modifier = Modifier.padding(innerPadding),
                text = "Hello Home")
        }
    }
}