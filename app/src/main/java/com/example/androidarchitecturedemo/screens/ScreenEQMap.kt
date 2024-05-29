package com.example.androidarchitecturedemo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.androidarchitecturedemo.R
import com.example.androidarchitecturedemo.views.GoogleMapCard
import com.example.data.model.Feature


@Composable
fun ScreenEQMap(navController: NavController, data: Feature?) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            GoogleMapCard(data = data)
            Button(onClick = { navController.popBackStack() }) {
                Image(painterResource(id = R.drawable.ic_back), contentDescription = "back")
            }
        }
    }
}