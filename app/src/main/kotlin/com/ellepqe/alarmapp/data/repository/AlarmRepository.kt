package com.ellepqe.alarmapp.data.repository

import com.ellepqe.alarmapp.data.dao.AlarmDao
import com.ellepqe.alarmapp.data.model.Alarm
import kotlinx.coroutines.flow.Flow

class AlarmRepository(private val alarmDao: AlarmDao) {
    fun getAllAlarms(): Flow<List<Alarm>> = alarmDao.getAllAlarms()

    fun getAlarmsByCategory(categoryId: Int): Flow<List<Alarm>> =
        alarmDao.getAlarmsByCategory(categoryId)

    suspend fun getAlarmById(id: Int): Alarm? = alarmDao.getAlarmById(id)

    suspend fun insertAlarm(alarm: Alarm): Long = alarmDao.insertAlarm(alarm)

    suspend fun updateAlarm(alarm: Alarm) = alarmDao.updateAlarm(alarm)

    suspend fun deleteAlarm(alarm: Alarm) = alarmDao.deleteAlarm(alarm)

    suspend fun deleteAlarmsByCategory(categoryId: Int) =
        alarmDao.deleteAlarmsByCategory(categoryId)
}
