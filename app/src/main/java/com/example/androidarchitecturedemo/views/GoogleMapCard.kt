package com.example.androidarchitecturedemo.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.data.model.Feature
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun GoogleMapCard(data: Feature?) {
    val berlinLatLng = LatLng(52.520008, 13.404954)
    val pinLatLng = data?.geometry?.let {
        LatLng(it.coordinates[1], it.coordinates[0])
    } ?: berlinLatLng
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(pinLatLng, 5f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = pinLatLng),
            title = data?.properties?.title,
            snippet = data?.properties?.detail
        )
    }
}