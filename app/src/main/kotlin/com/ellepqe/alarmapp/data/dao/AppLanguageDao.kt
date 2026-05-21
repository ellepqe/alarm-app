package com.ellepqe.alarmapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ellepqe.alarmapp.data.model.AppLanguage
import kotlinx.coroutines.flow.Flow

@Dao
interface AppLanguageDao {
    @Insert
    suspend fun insertLanguage(appLanguage: AppLanguage)

    @Update
    suspend fun updateLanguage(appLanguage: AppLanguage)

    @Delete
    suspend fun deleteLanguage(appLanguage: AppLanguage)

    @Query("SELECT * FROM app_language WHERE key = :key")
    suspend fun getLanguageByKey(key: String): AppLanguage?

    @Query("SELECT * FROM app_language ORDER BY key ASC")
    fun getAllLanguages(): Flow<List<AppLanguage>>
}
