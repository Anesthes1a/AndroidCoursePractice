package com.example.androidcoursepractice.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androidcoursepractice.MainViewModel
import com.example.androidcoursepractice.navigation.BottomBarUI
import com.example.androidcoursepractice.navigation.NavGraph
import com.example.androidcoursepractice.model.ScreenBarElements

@Composable
fun BottomBarScreen(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val screens = listOf(
        ScreenBarElements.Home,
        ScreenBarElements.AllProducts,
        ScreenBarElements.FavouriteProducts,
        ScreenBarElements.Profile
    )

    val showBottomBar = currentDestination?.route in screens.map { it.route }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                BottomBarUI(
                    navController = navController,
                    screens = screens
                )
            }
        }
    )
    { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavGraph(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}