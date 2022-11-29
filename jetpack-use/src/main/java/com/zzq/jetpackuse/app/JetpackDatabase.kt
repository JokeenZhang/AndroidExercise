package com.zzq.jetpackuse.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zzq.jetpackuse.db.dao.StartupDao
import com.zzq.jetpackuse.db.entity.StartupPO

@Database(entities = [StartupPO::class], exportSchema = false, version = 1)
abstract class JetpackDatabase : RoomDatabase() {
    abstract val startupDao: StartupDao

    companion object {
        @Volatile
        private var INSTANCE: JetpackDatabase? = null

        fun getInstance(context: Context): JetpackDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        JetpackDatabase::class.java,
                        "jetpack-use-db"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}