package com.ellepqe.alarmapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Ignore

@Entity(tableName = "alarms")
data class Alarm(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val time: String = "", // HH:mm format
    val soundUri: String = "",
    val isEnabled: Boolean = true,
    val categoryId: Int = 0,
    val description: String = "",
    val textColor: Int = -16777216, // Black
    val textSize: Int = 14,
    val vibrateEnabled: Boolean = false,
    val linkedAlarmId: Int? = null, // For chaining alarms
    val muteWhenOtherActive: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
