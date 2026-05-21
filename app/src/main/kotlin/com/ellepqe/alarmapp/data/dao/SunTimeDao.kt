package com.ellepqe.alarmapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ellepqe.alarmapp.data.model.SunTime
import kotlinx.coroutines.flow.Flow

@Dao
interface SunTimeDao {
    @Insert
    suspend fun insertSunTime(sunTime: SunTime): Long

    @Update
    suspend fun updateSunTime(sunTime: SunTime)

    @Delete
    suspend fun deleteSunTime(sunTime: SunTime)

    @Query("SELECT * FROM sun_times ORDER BY date DESC, time ASC")
    fun getAllSunTimes(): Flow<List<SunTime>>

    @Query("SELECT * FROM sun_times WHERE type = :type ORDER BY date DESC")
    fun getSunTimesByType(type: String): Flow<List<SunTime>>
}
