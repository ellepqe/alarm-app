package com.ellepqe.alarmapp.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.ellepqe.alarmapp.R

class SunMoonNotificationService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val timeType = intent?.getStringExtra("time_type") ?: "Unknown"
        val time = intent?.getStringExtra("time") ?: "00:00"

        showNotification(timeType, time)
        return START_NOT_STICKY
    }

    private fun showNotification(timeType: String, time: String) {
        val notification = NotificationCompat.Builder(this, "sun_moon_channel")
            .setContentTitle("$timeType Alert")
            .setContentText("Time: $time")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        startForeground(2, notification)
        stopSelf()
    }
}
