package com.ellepqe.alarmapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ellepqe.alarmapp.services.SunMoonNotificationService

class SunMoonReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent?.action == "com.ellepqe.alarmapp.SUN_MOON_TRIGGER") {
            val timeType = intent.getStringExtra("time_type") ?: "Unknown"
            val time = intent.getStringExtra("time") ?: "00:00"

            val serviceIntent = Intent(context, SunMoonNotificationService::class.java)
            serviceIntent.putExtra("time_type", timeType)
            serviceIntent.putExtra("time", time)
            context.startService(serviceIntent)
        }
    }
}
