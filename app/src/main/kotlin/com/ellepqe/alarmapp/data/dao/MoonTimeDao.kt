package com.ellepqe.alarmapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ellepqe.alarmapp.data.model.MoonTime
import kotlinx.coroutines.flow.Flow

@Dao
interface MoonTimeDao {
    @Insert
    suspend fun insertMoonTime(moonTime: MoonTime): Long

    @Update
    suspend fun updateMoonTime(moonTime: MoonTime)

    @Delete
    suspend fun deleteMoonTime(moonTime: MoonTime)

    @Query("SELECT * FROM moon_times ORDER BY date DESC, time ASC")
    fun getAllMoonTimes(): Flow<List<MoonTime>>

    @Query("SELECT * FROM moon_times WHERE phase = :phase ORDER BY date DESC")
    fun getMoonTimesByPhase(phase: String): Flow<List<MoonTime>>
}
