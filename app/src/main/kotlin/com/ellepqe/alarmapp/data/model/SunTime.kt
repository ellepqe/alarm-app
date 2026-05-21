package com.ellepqe.alarmapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sun_times")
data class SunTime(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val type: String = "", // "sunrise" or "sunset"
    val time: String = "", // HH:mm format
    val date: String = "", // yyyy-MM-dd format
    val isEnabled: Boolean = true,
    val description: String = "",
    val textColor: Int = -16777216,
    val textSize: Int = 14,
    val createdAt: Long = System.currentTimeMillis()
)
