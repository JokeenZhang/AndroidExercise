package com.zzq.jetpackuse.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.zzq.jetpackuse.db.entity.AppExceptionPO
import kotlinx.coroutines.flow.Flow

@Dao
interface AppExceptionDao {

    @Query("select * from app_exception")
    fun queryAllAppException(): Flow<List<AppExceptionPO>>

    /**
     * 查找异常记录，只返回id，这里只需要知道表格的length，不需要拿到太多的数据
     */
    @Query("select id from app_exception")
    suspend fun queryPreviousException(): List<Long>

    @Insert
    suspend fun addException(item: AppExceptionPO)
}