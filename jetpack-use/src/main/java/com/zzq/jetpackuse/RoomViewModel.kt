package com.zzq.jetpackuse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zzq.jetpackuse.db.entity.StartupPO
import com.zzq.jetpackuse.repository.DbAppExceptionRepository
import com.zzq.jetpackuse.repository.DbStartupRepository
import com.zzq.jetpackuse.utils.AndroidInfoUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val dbStartupRepository: DbStartupRepository,
    private val dbAppExceptionRepository: DbAppExceptionRepository
) : ViewModel() {

    /**
     * 启动时准备数据，如新增启动记录。
     */
    fun prepareDbDataInStartup() {
        viewModelScope.launch {
            createStartupRecord()
            prepareAppException()
        }
    }

    private suspend fun createStartupRecord() {
        dbStartupRepository.addItem(
            StartupPO(
                AndroidInfoUtil.getSystemVersion() ?: "",
                AndroidInfoUtil.getSystemModel() ?: "",
                AndroidInfoUtil.getDeviceManufacturer() ?: "",
                AndroidInfoUtil.getDeviceBrand() ?: ""
            )
        )

    }

    /**
     * 准备新增测试异常记录，如果没有记录的话
     */
    private suspend fun prepareAppException() {
        val size = dbAppExceptionRepository.queryExceptionSize()
        if (size == 0) {
            dbAppExceptionRepository.insertTestAppException()
        }

    }
}