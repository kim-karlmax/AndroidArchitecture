package com.example.androidarchitecturedemo.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidarchitecturedemo.R
import com.example.domain.UsecaseGetEarthquakeData
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    val usecase: UsecaseGetEarthquakeData by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usecase.getDemoData()
    }
}