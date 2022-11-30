package com.zzq.jetpackuse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zzq.jetpackuse.db.entity.StartupPO
import com.zzq.jetpackuse.repository.DbStartupRepository
import com.zzq.jetpackuse.utils.AndroidInfoUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val dbStartupRepository: DbStartupRepository
) : ViewModel() {

    fun createStartupRecord() {
        viewModelScope.launch {
            dbStartupRepository.addItem(
                StartupPO(
                    AndroidInfoUtil.getSystemVersion() ?: "",
                    AndroidInfoUtil.getSystemModel() ?: "",
                    AndroidInfoUtil.getDeviceManufacturer() ?: "",
                    AndroidInfoUtil.getDeviceBrand() ?: ""
                )
            )
        }
    }
}