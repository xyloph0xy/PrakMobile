package com.luluksofiyah.uas.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.luluksofiyah.uas.ui.screens.detail.DetailScreen
import com.luluksofiyah.uas.ui.screens.home.HomeSc

@Composable
fun UasNavHost(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = UasScreen.HOME.route,
        modifier = Modifier.padding(innerPadding),
    ) {
        homeComposable(navController = navController)
        detailComposable(navController = navController)
    }
}

fun NavGraphBuilder.homeComposable(navController: NavHostController) {
    composable(
        route = UasScreen.HOME.route,
        content = {
            HomeSc(
                navController = navController,
            )
        }
    )
}

fun NavGraphBuilder.detailComposable(navController: NavHostController) {
    composable(
        route = "${UasScreen.DETAIL.route}/{movieId}",
        arguments = listOf(
            navArgument(name = "movieId") {
                type = NavType.IntType
            }
        ),
        content = {
            val movieId = navController.currentBackStackEntry?.arguments?.getInt("movieId")
            DetailScreen(movieId = movieId)
        }
    )
}
