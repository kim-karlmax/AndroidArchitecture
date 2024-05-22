package com.example.androidarchitecturedemo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidarchitecturedemo.views.GoogleMapCard
import com.example.data.model.Feature


@Composable
fun ScreenEQMap(navController: NavController, data: Feature?) {
    var text = ""
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GoogleMapCard(data = data, navController = navController)
//        data?.let {
//            Text(it.properties.title, style = MaterialTheme.typography.titleLarge)
//            Text("${it.geometry.coordinates[0]}, ${it.geometry.coordinates[1]}", style = MaterialTheme.typography.titleLarge)
//        }
//        Spacer(Modifier.height(8.dp))
//        Button(onClick = {
//            navController.previousBackStackEntry?.savedStateHandle?.set("msg", text)
//            navController.popBackStack()
//        }) {
//            Text(text = "Submit")
//        }
    }
}