package com.example.androidcoursepractice

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.androidcoursepractice.screens.BottomBarScreen

class MyApplication : Application(){
    @Composable
    fun NavHost(){
        val navController = rememberNavController()
        val viewModel: MainViewModel = MainViewModel()
        BottomBarScreen(
            navController = navController,
            viewModel = viewModel,
        )
    }
}