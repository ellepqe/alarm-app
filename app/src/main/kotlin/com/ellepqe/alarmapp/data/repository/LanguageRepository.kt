package com.ellepqe.alarmapp.data.repository

import com.ellepqe.alarmapp.data.dao.AppLanguageDao
import com.ellepqe.alarmapp.data.model.AppLanguage
import kotlinx.coroutines.flow.Flow

class LanguageRepository(private val appLanguageDao: AppLanguageDao) {
    fun getAllLanguages(): Flow<List<AppLanguage>> = appLanguageDao.getAllLanguages()

    suspend fun getLanguageByKey(key: String): AppLanguage? =
        appLanguageDao.getLanguageByKey(key)

    suspend fun insertLanguage(appLanguage: AppLanguage) =
        appLanguageDao.insertLanguage(appLanguage)

    suspend fun updateLanguage(appLanguage: AppLanguage) =
        appLanguageDao.updateLanguage(appLanguage)

    suspend fun deleteLanguage(appLanguage: AppLanguage) =
        appLanguageDao.deleteLanguage(appLanguage)
}
