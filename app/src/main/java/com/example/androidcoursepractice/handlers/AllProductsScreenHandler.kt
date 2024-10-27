package com.example.androidcoursepractice.handlers

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import com.example.androidcoursepractice.model.ScreenBarElements

class AllProductsScreenHandler(
    val navController: NavHostController
) {
    fun onToProductDetail(index: Int){
        navController.navigate(ScreenBarElements.ProductDetail.route+"/$index")
        if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
            navController.popBackStack()
        }
    }
}