package com.example.androidcoursepractice.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenBarElements(
    val route: String,
    val title: String? = null,
    val setIcon: ImageVector? = null,
    val unsetIcon: ImageVector? = null
){
    data object AllProducts : ScreenBarElements(
        route = PRODUCTS_ROUTE,
        title = PRODUCTS_TITLE,
        setIcon = PRODUCTS_SET_ICON,
        unsetIcon = PRODUCTS_UNSET_ICON
    )

    data object ProductDetail : ScreenBarElements(
        route = PDETAIL_ROUTE,
        title = PDETAIL_TITLE,
    )

    data object Home : ScreenBarElements(
        route = HOME_ROUTE,
        title = HOME_TITLE,
        setIcon = HOME_SET_ICON,
        unsetIcon = HOME_UNSET_ICON
    )

    data object FavouriteProducts : ScreenBarElements(
        route = FAVOURITE_ROUTE,
        title = FAVOURITE_TITLE,
        setIcon = FAVOURITE_SET_ICON,
        unsetIcon = FAVOURITE_UNSET_ICON
    )

    data object Profile : ScreenBarElements(
        route = PROFILE_ROUTE,
        title = PROFILE_TITLE,
        setIcon = PROFILE_SET_ICON,
        unsetIcon = PROFILE_UNSET_ICON
    )

    companion object{
        private const val PRODUCTS_ROUTE = "PRODUCTS_ROUTE"
        private const val PRODUCTS_TITLE = "Продукты"
        private val PRODUCTS_SET_ICON = Icons.Filled.Menu
        private val PRODUCTS_UNSET_ICON = Icons.Outlined.Menu

        private const val PDETAIL_ROUTE = "PDETAIL_ROUTE"
        private const val PDETAIL_TITLE = "Подробнее о продукте"

        private const val HOME_ROUTE = "HOME_ROUTE"
        private const val HOME_TITLE = "Домашняя страница"
        private val HOME_SET_ICON = Icons.Filled.Home
        private val HOME_UNSET_ICON = Icons.Outlined.Home

        private const val FAVOURITE_ROUTE = "FAVOURITE_ROUTE"
        private const val FAVOURITE_TITLE = "Избранные продукты"
        private val FAVOURITE_SET_ICON = Icons.Filled.Star
        private val FAVOURITE_UNSET_ICON = Icons.Outlined.FavoriteBorder

        private const val PROFILE_ROUTE = "PROFILE_ROUTE"
        private const val PROFILE_TITLE = "Профиль"
        private val PROFILE_SET_ICON = Icons.Filled.AccountCircle
        private val PROFILE_UNSET_ICON = Icons.Outlined.AccountCircle
    }
}