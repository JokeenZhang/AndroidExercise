package com.zzq.jetpackuse.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_exception")
data class AppExceptionPO(
    val type: String,
    val message: String,
    @ColumnInfo(name = "time_millis")
    val timeMillis: Long = System.currentTimeMillis()
) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}
