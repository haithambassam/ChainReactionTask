package com.haitham.chainreactiontask

import android.app.Application
import com.facebook.FacebookSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        FacebookSdk.fullyInitialize()
    }
}