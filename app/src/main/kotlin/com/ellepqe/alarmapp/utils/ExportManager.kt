package com.ellepqe.alarmapp.utils

import android.content.Context
import com.google.gson.Gson
import java.io.File

class ExportManager(private val context: Context) {
    fun exportToJson(
        alarms: String,
        categories: String,
        moonTimes: String,
        sunTimes: String,
        notes: String
    ): String {
        val fileName = "alarm_backup_${System.currentTimeMillis()}.json"
        val file = File(context.getExternalFilesDir(null), fileName)
        
        val jsonData = mapOf(
            "alarms" to alarms,
            "categories" to categories,
            "moonTimes" to moonTimes,
            "sunTimes" to sunTimes,
            "notes" to notes,
            "exportedAt" to System.currentTimeMillis()
        )
        
        val json = Gson().toJson(jsonData)
        file.writeText(json)
        return file.absolutePath
    }

    fun exportToText(
        alarms: String,
        categories: String,
        moonTimes: String,
        sunTimes: String,
        notes: String
    ): String {
        val fileName = "alarm_backup_${System.currentTimeMillis()}.txt"
        val file = File(context.getExternalFilesDir(null), fileName)
        
        val textData = buildString {
            append("=== ALARM BACKUP ===")
            append("\n\n")
            append("ALARMS:\n")
            append(alarms)
            append("\n\n")
            append("CATEGORIES:\n")
            append(categories)
            append("\n\n")
            append("MOON TIMES:\n")
            append(moonTimes)
            append("\n\n")
            append("SUN TIMES:\n")
            append(sunTimes)
            append("\n\n")
            append("NOTES:\n")
            append(notes)
            append("\n\n")
            append("Exported: ${System.currentTimeMillis()}")
        }
        
        file.writeText(textData)
        return file.absolutePath
    }
}
