package com.fourmainandroidcomponents.broadcastreceiverapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


private const val TAG = "BATTERY_REC"

class BatteryLevelReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Low battery!")
    }
}