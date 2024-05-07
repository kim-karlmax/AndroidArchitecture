package com.example.androidarchitecturedemo.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.ui.theme.AndroidArchitectureDemoTheme
import com.example.androidarchitecturedemo.viewmodels.MainActivityViewModel

class MainActivity : ComponentActivity() {
    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]

        setContent {
            AndroidArchitectureDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn {
                        items(vm.earthquakeDataState.value) {
                            EarthquakeCard(it)
                        }
                    }
                }
            }
        }
    }
}