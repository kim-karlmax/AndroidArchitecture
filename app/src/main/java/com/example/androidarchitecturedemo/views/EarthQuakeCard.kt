package com.example.androidarchitecturedemo.views

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidarchitecturedemo.screens.Screen
import com.example.androidarchitecturedemo.screens.navigate
import com.example.data.model.Feature
import com.example.data.model.Geometry
import com.example.data.model.Properties
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun EarthquakeCard(data: Feature, navController: NavController?) {
    data.properties.place?.let {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(5.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .clickable {
                        Log.d("myapp", "clicked")
                        val bundle = Bundle()
                        bundle.putParcelable("item", data)
                        navController?.navigate(route = Screen.MAP.name,
                            args = bundle)
                    }
            ) {
                val dt = Instant.ofEpochMilli(data.properties.time).atZone(ZoneId.systemDefault())
                    .toLocalDateTime()
                Text(data.properties.title, style = MaterialTheme.typography.titleLarge)
                Text(
                    dt.format(DateTimeFormatter.ISO_DATE_TIME),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text("MAG = " + data.properties.mag, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(heightDp = 200)
@Composable
fun Preview_eq_card() {
    val testdata = Feature(
        type = "test",
        id = "test_id",
        properties = Properties(
            mag = 7.0,
            place = "test_place",
            time = 1231231231231,
            updated = 1231231231231,
            tz = "123123",
            url = "test_url",
            detail = "test_detail",
            felt = "anyany",
            cdi = "anyany",
            mmi = "anyany",
            alert = "anyany",
            status = "test_status",
            tsunami = 1,
            sig = 1,
            net = "test_net",
            code = "test_code",
            ids = "test_ids",
            sources = "test_sources",
            types = "test_types",
            nst = 1,
            dmin = 1.0,
            rms = 1.0,
            gap = 1,
            magType = "test_mag_type",
            type = "test_type",
            title = "Test Title",
        ),
        geometry = Geometry(
            type = "test_type",
            coordinates = listOf<Double>(1.0, 1.0)
        )
    )

    EarthquakeCard(data = testdata, navController = null)
}