package com.fourmainandroidactivity.broadcastreceiverapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_LOCALE_CHANGED
import android.util.Log
import java.util.*

private const val TAG = "LOCALE_REC"

class LocaleReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action != ACTION_LOCALE_CHANGED)
            return

        Log.d(TAG, "new locale: ${Locale.getDefault()}")
    }
}