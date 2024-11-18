package com.example.androidcoursepractice.presentation.handlers

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import com.example.androidcoursepractice.presentation.model.ScreenBarElements

class AllProductsScreenHandler(
    val navController: NavHostController
) {
    fun onToProductDetail(index: Long){
        navController.navigate(ScreenBarElements.ProductDetail.route+"/$index")
        if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
            navController.popBackStack()
        }
    }
}