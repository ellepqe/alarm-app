package com.ellepqe.alarmapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_language")
data class AppLanguage(
    @PrimaryKey
    val key: String,
    val defaultValue: String = "",
    val customValue: String = ""
)
