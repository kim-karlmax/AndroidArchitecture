package com.example.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class EarthquakeDto(
    val type: String,
    val metadata: Metadata,
    val features: List<Feature>,
    val bbox: List<Double>,
)

data class Metadata(
    val generated: Long,
    val url: String,
    val title: String,
    val status: Long,
    val api: String,
    val count: Long,
)

@Parcelize
data class Feature(
    val type: String,
    val properties: Properties,
    val geometry: Geometry,
    val id: String,
) : Parcelable

@Parcelize
data class Properties(
    val mag: Double,
    val place: String?,
    val time: Long,
    val updated: Long,
    val tz: String?,
    val url: String,
    val detail: String,
    val felt: String?,
    val cdi: String?,
    val mmi: String?,
    val alert: String?,
    val status: String,
    val tsunami: Long,
    val sig: Long,
    val net: String,
    val code: String,
    val ids: String,
    val sources: String,
    val types: String,
    val nst: Long,
    val dmin: Double,
    val rms: Double,
    val gap: Long,
    val magType: String,
    val type: String,
    val title: String,
) : Parcelable

@Parcelize
data class Geometry(
    val type: String,
    val coordinates: List<Double>,
) : Parcelable
