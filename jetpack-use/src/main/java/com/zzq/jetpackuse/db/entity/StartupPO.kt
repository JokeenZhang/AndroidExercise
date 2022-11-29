package com.zzq.jetpackuse.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "startup_list")
data class StartupPO(

    val timeMillis: Long = System.currentTimeMillis(),
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}
