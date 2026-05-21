package com.ellepqe.alarmapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ellepqe.alarmapp.services.AlarmService

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent?.action == "com.ellepqe.alarmapp.ALARM_TRIGGER") {
            val alarmId = intent.getIntExtra("alarm_id", -1)
            val alarmTitle = intent.getStringExtra("alarm_title") ?: "Alarm"

            val serviceIntent = Intent(context, AlarmService::class.java)
            serviceIntent.putExtra("alarm_id", alarmId)
            serviceIntent.putExtra("alarm_title", alarmTitle)
            context.startService(serviceIntent)
        }
    }
}
