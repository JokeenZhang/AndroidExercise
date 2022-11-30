package com.zzq.jetpackuse.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "startup_list")
data class StartupPO(
    @ColumnInfo(name = "system_version", typeAffinity = ColumnInfo.TEXT, defaultValue = "")
    val systemVersion: String,

    @ColumnInfo(name = "system_model", typeAffinity = ColumnInfo.TEXT, defaultValue = "")
    val systemModel: String,

    @ColumnInfo(name = "device_manufacturer", typeAffinity = ColumnInfo.TEXT, defaultValue = "")
    val deviceManufacturer: String,

    @ColumnInfo(name = "device_brand", typeAffinity = ColumnInfo.TEXT, defaultValue = "")
    val deviceBrand: String,

    val timeMillis: Long = System.currentTimeMillis(),
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}
