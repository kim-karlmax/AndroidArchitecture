package com.example.androidarchitecturedemo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.androidarchitecturedemo.viewmodels.MainActivityViewModel
import com.example.androidarchitecturedemo.views.EarthquakeCard


@Composable
fun ScreenEQList(navController: NavController, vm: MainActivityViewModel) {

    // next item: paging for list
    val eqPagingItems = vm.earthquakeState.collectAsLazyPagingItems()

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            if (eqPagingItems.loadState.refresh == LoadState.Loading) {
                item {
                    Text(
                        text = "Loading...",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }

            items(eqPagingItems.itemCount) {index ->
                eqPagingItems[index]?.let { item ->
                    EarthquakeCard(item, navController)
                }
            }

            if (eqPagingItems.loadState.append == LoadState.Loading) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}