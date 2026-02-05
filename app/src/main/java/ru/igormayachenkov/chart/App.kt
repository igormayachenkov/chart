package ru.igormayachenkov.chart

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

private const val TAG = "myapp.App"

@HiltAndroidApp
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        Log.w(TAG, "onCreate")
    }
}