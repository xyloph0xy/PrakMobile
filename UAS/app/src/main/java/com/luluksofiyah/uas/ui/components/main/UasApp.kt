package com.luluksofiyah.uas.ui.components.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.luluksofiyah.uas.ui.navigation.UasNavHost
import com.luluksofiyah.uas.ui.navigation.UasScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UasApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route?.let { route ->
        when (route) {
            UasScreen.HOME.route -> UasScreen.HOME
            "${UasScreen.DETAIL.route}/{movieId}" -> UasScreen.DETAIL
            else -> null
        }
    } ?: UasScreen.HOME

   Scaffold (topBar = {
       UasTopBar(
           currentScreen = currentScreen,
           canNavigateBack = navController.previousBackStackEntry != null,
           navigateUp = {
               navController.navigateUp()
           },
       )
   },
       content = { innerPadding ->
           UasNavHost(navController = navController, innerPadding = innerPadding)
       })
}