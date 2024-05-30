package com.example.androidarchitecturedemo.screens

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

enum class Screen {
    LIST,
    MAP,
}
sealed class NavigationItem(val route: String) {
    object List : NavigationItem(Screen.LIST.name)
    object Map : NavigationItem(Screen.MAP.name)
}

fun NavController.navigate(
    route: String,
    args: Bundle,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    val nodeId = graph.findNode(route = route)?.id
    if (nodeId != null) {
        navigate(nodeId, args, navOptions, navigatorExtras)
    }
}