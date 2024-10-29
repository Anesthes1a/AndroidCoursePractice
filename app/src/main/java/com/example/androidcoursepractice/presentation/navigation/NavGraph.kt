package com.example.androidcoursepractice.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcoursepractice.presentation.model.ScreenBarElements
import com.example.androidcoursepractice.presentation.screens.AllProductsScreen
import com.example.androidcoursepractice.presentation.screens.FavoriteProductsScreen
import com.example.androidcoursepractice.presentation.screens.HomeScreen
import com.example.androidcoursepractice.presentation.screens.ProductDetailScreen
import com.example.androidcoursepractice.presentation.screens.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenBarElements.Home.route
    )
    {
        composable(route = ScreenBarElements.Home.route){
            HomeScreen()
        }
        composable(route = ScreenBarElements.ProductDetail.route+"/{index}"){ backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toInt() ?: 0
            ProductDetailScreen(id = index)
                .Content(modifier = Modifier.fillMaxSize())
        }
        composable(route = ScreenBarElements.AllProducts.route){
            AllProductsScreen(navController = navController)
                .Content(modifier = Modifier.fillMaxSize())
        }
        composable(route = ScreenBarElements.FavouriteProducts.route){
            FavoriteProductsScreen()
        }
        composable(route = ScreenBarElements.Profile.route){
            ProfileScreen()
        }
    }
}