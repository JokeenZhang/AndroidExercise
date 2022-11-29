package com.zzq.jetpackuse.repository

import com.zzq.jetpackuse.db.dao.StartupDao
import com.zzq.jetpackuse.db.entity.StartupPO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbStartupRepository @Inject constructor(private val startupDao: StartupDao) {

    fun getStartups() = startupDao.queryAllStartup()

    suspend fun addItem(item: StartupPO) {
        startupDao.addData(item)
    }
}