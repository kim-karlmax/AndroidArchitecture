package com.example.androidarchitecturedemo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.androidarchitecturedemo.viewmodels.MainActivityViewModel
import com.example.androidarchitecturedemo.views.EarthquakeCard

@Composable
fun ScreenEQList(navController: NavController, vm: MainActivityViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(vm.earthquakeDataState.value) {
                EarthquakeCard(it, navController)
            }
        }
    }
}
