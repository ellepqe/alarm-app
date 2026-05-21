package com.ellepqe.alarmapp.data.repository

import com.ellepqe.alarmapp.data.dao.CategoryDao
import com.ellepqe.alarmapp.data.model.Category
import kotlinx.coroutines.flow.Flow

class CategoryRepository(private val categoryDao: CategoryDao) {
    fun getAllCategories(): Flow<List<Category>> = categoryDao.getAllCategories()

    suspend fun getCategoryById(id: Int): Category? = categoryDao.getCategoryById(id)

    suspend fun insertCategory(category: Category): Long =
        categoryDao.insertCategory(category)

    suspend fun updateCategory(category: Category) = categoryDao.updateCategory(category)

    suspend fun deleteCategory(category: Category) = categoryDao.deleteCategory(category)
}
