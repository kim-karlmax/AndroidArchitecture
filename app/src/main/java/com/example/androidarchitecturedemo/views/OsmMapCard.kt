package com.example.androidarchitecturedemo.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.data.model.Feature
import org.osmdroid.tileprovider.MapTileProviderBasic
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.tileprovider.util.SimpleInvalidationHandler
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

@Composable
fun OsmMapCard(data: Feature?) {
    val geoPoint = remember {
        data?.let { GeoPoint(it.geometry.coordinates[1], it.geometry.coordinates[0]) }
    }

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            // Creates the view
            MapView(context).apply {
                // Do anything that needs to happen on the view init here
                // For example set the tile source or add a click listener
                controller.setCenter(geoPoint)

                tileProvider = MapTileProviderBasic(context, TileSourceFactory.USGS_SAT)
                tileProvider.tileRequestCompleteHandlers.add(SimpleInvalidationHandler(this))
                val startMarker = Marker(this)
                startMarker.position = geoPoint
                startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                startMarker.title = data?.properties?.title
                overlays.add(startMarker)
            }
        },
        update = { view ->
            // Code to update or recompose the view goes here
            // Since geoPoint is read here, the view will recompose whenever it is updated\
            view.controller.setCenter(geoPoint)
            view.controller.zoomTo(6.0)
        }
    )
}
