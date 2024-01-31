package com.luluksofiyah.uas.ui.navigation

import okhttp3.Route

sealed class UasScreen(val route: String){
    object HOME : UasScreen("Home")
    object DETAIL : UasScreen("Detail")
}



