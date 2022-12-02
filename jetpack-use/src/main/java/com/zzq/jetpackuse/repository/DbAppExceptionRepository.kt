package com.zzq.jetpackuse.repository

import com.zzq.jetpackuse.app.AppConstant
import com.zzq.jetpackuse.db.dao.AppExceptionDao
import com.zzq.jetpackuse.db.entity.AppExceptionPO
import javax.inject.Inject

class DbAppExceptionRepository @Inject constructor(private val dao: AppExceptionDao) {

    suspend fun queryExceptionSize(): Int {
        var list = dao.queryPreviousException()
        return list.size
    }

    /**
     * 插入一条测试用的异常记录
     */
    suspend fun insertTestAppException() {
        insertAppException(
            AppExceptionPO(
                AppConstant.EXCEPTION_TEST_TYPE,
                AppConstant.EXCEPTION_TEST_MESSAGE
            )
        )
    }

    suspend fun insertAppException(appExceptionPO: AppExceptionPO) {
        dao.addException(appExceptionPO)
    }

}