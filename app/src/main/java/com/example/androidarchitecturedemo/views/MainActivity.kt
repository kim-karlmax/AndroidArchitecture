package com.example.androidarchitecturedemo.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.R
import com.example.androidarchitecturedemo.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]
    }
}