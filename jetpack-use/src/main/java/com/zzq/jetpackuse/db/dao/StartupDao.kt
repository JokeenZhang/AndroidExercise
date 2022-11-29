package com.zzq.jetpackuse.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.zzq.jetpackuse.db.entity.StartupPO
import kotlinx.coroutines.flow.Flow

@Dao
interface StartupDao {

    /**
     * 查询全部数据
     */
    @Query("select * from STARTUP_LIST")
    fun queryAllStartup(): Flow<List<StartupPO>>

    /**
     * 查找指定时间段的数据
     */
    @Query("select * from STARTUP_LIST where timeMillis >= :start and timeMillis <= :end")
    fun queryStartupInMonth(start: Long, end: Long): Flow<List<StartupPO>>

    @Insert
    suspend fun addData(item: StartupPO)
}