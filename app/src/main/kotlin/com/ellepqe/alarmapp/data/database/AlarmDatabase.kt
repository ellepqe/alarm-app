package com.ellepqe.alarmapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ellepqe.alarmapp.data.dao.AlarmDao
import com.ellepqe.alarmapp.data.dao.AppLanguageDao
import com.ellepqe.alarmapp.data.dao.CategoryDao
import com.ellepqe.alarmapp.data.dao.MoonTimeDao
import com.ellepqe.alarmapp.data.dao.NoteDao
import com.ellepqe.alarmapp.data.dao.SunTimeDao
import com.ellepqe.alarmapp.data.model.Alarm
import com.ellepqe.alarmapp.data.model.AppLanguage
import com.ellepqe.alarmapp.data.model.Category
import com.ellepqe.alarmapp.data.model.MoonTime
import com.ellepqe.alarmapp.data.model.Note
import com.ellepqe.alarmapp.data.model.SunTime

@Database(
    entities = [
        Alarm::class,
        Category::class,
        MoonTime::class,
        SunTime::class,
        Note::class,
        AppLanguage::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AlarmDatabase : RoomDatabase() {
    abstract fun alarmDao(): AlarmDao
    abstract fun categoryDao(): CategoryDao
    abstract fun moonTimeDao(): MoonTimeDao
    abstract fun sunTimeDao(): SunTimeDao
    abstract fun noteDao(): NoteDao
    abstract fun appLanguageDao(): AppLanguageDao
}
