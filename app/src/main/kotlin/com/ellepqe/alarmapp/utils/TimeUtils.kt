package com.ellepqe.alarmapp.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TimeUtils {
    companion object {
        fun getCurrentTime(): String {
            val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            return sdf.format(System.currentTimeMillis())
        }

        fun getCurrentDate(): String {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return sdf.format(System.currentTimeMillis())
        }

        fun isTimeReached(targetTime: String, currentTime: String): Boolean {
            return targetTime == currentTime
        }

        fun parseTime(timeString: String): Pair<Int, Int> {
            val parts = timeString.split(":")
            return Pair(parts[0].toInt(), parts[1].toInt())
        }

        fun formatTime(hour: Int, minute: Int): String {
            return String.format("%02d:%02d", hour, minute)
        }
    }
}
