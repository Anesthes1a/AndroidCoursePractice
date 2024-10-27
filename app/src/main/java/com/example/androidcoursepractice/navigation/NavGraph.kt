package com.example.androidcoursepractice.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcoursepractice.handlers.AllProductsScreenHandler
import com.example.androidcoursepractice.MainViewModel
import com.example.androidcoursepractice.model.ScreenBarElements
import com.example.androidcoursepractice.screens.AllProductsScreen
import com.example.androidcoursepractice.screens.FavoriteProductsScreen
import com.example.androidcoursepractice.screens.HomeScreen
import com.example.androidcoursepractice.screens.ProductDetailScreen
import com.example.androidcoursepractice.screens.ProfileScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: MainViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = ScreenBarElements.Home.route
    )
    {
        composable(route = ScreenBarElements.Home.route){
            HomeScreen(
                viewModel = viewModel
            )
        }
        composable(route = ScreenBarElements.ProductDetail.route+"/{index}"){ backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toInt() ?: 0
            ProductDetailScreen(
                index = index,
                viewModel = viewModel
            )
        }
        composable(route = ScreenBarElements.AllProducts.route){
            AllProductsScreen(
                handler = AllProductsScreenHandler(navController = navController),
                viewModel = viewModel
            )
        }
        composable(route = ScreenBarElements.FavouriteProducts.route){
            FavoriteProductsScreen(
                viewModel = viewModel
            )
        }
        composable(route = ScreenBarElements.Profile.route){
            ProfileScreen(
                viewModel = viewModel
            )
        }
    }
}