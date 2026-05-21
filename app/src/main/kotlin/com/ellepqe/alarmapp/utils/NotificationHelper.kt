package com.ellepqe.alarmapp.utils

import android.content.Context
import androidx.core.app.NotificationCompat
import com.ellepqe.alarmapp.R

class NotificationHelper(private val context: Context) {
    fun createNotification(title: String, message: String, channelId: String): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
    }

    fun createAlarmNotification(alarmTitle: String): NotificationCompat.Builder {
        return createNotification(
            "Alarm: $alarmTitle",
            "Time to wake up!",
            "alarm_channel"
        )
    }

    fun createSunMoonNotification(type: String, time: String): NotificationCompat.Builder {
        return createNotification(
            "$type Event",
            "Time: $time",
            "sun_moon_channel"
        )
    }
}
