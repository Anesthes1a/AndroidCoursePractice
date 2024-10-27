package com.example.androidcoursepractice.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androidcoursepractice.model.ScreenBarElements


@Composable
fun BottomBarUI(
    navController: NavController,
    screens: List<ScreenBarElements>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation{
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.setIcon ?: Icons.TwoTone.Build, contentDescription = screen.title) },
                label = { Text(screen.title ?: "Nothing") },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}