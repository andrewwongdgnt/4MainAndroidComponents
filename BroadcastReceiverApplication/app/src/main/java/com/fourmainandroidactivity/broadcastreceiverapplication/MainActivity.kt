package com.fourmainandroidactivity.broadcastreceiverapplication

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val receiver by lazy { BatteryLevelReceiver() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        //registering the receiver...
        registerReceiver(receiver, IntentFilter(Intent.ACTION_BATTERY_LOW))
    }

    override fun onStop() {
        //Unregistering the receiver...
        super.onStop()
        unregisterReceiver(receiver)
    }
}