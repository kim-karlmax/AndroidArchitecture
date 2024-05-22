package com.example.androidarchitecturedemo.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidarchitecturedemo.screens.Screen
import com.example.androidarchitecturedemo.screens.ScreenEQList
import com.example.androidarchitecturedemo.screens.ScreenEQMap
import com.example.androidarchitecturedemo.ui.theme.AndroidArchitectureDemoTheme
import com.example.androidarchitecturedemo.viewmodels.MainActivityViewModel
import com.example.data.model.Feature

class MainActivity : ComponentActivity() {
    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]

        setContent {
            AndroidArchitectureDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.LIST.name
                    ) {
                        composable(Screen.LIST.name) {
                            ScreenEQList(navController, vm)
                        }
                        composable(Screen.MAP.name) {
                            val bundle = it.arguments
                            val data = bundle?.getParcelable("item") as? Feature
                            ScreenEQMap(navController, data)
                        }
                    }
                }
            }
        }
    }
}

