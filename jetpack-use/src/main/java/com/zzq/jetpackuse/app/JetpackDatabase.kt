package com.zzq.jetpackuse.app

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zzq.jetpackuse.db.dao.StartupDao
import com.zzq.jetpackuse.db.entity.StartupPO

@Database(
    entities = [StartupPO::class],
    exportSchema = true,
    version = 2,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class JetpackDatabase : RoomDatabase() {
    abstract val startupDao: StartupDao

    companion object {
        @Volatile
        private var INSTANCE: JetpackDatabase? = null

        fun getInstance(context: Context): JetpackDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            JetpackDatabase::class.java,
                            "jetpack-use-db"
                        )
//                        .fallbackToDestructiveMigration()
                        .addMigrations(MIGRATION_1_2)
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

        /**
         * startup_list表增加多个列
         */
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE startup_list ADD COLUMN system_version TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE startup_list ADD COLUMN system_model TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE startup_list ADD COLUMN device_manufacturer TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE startup_list ADD COLUMN device_brand TEXT NOT NULL DEFAULT ''")

//                database.execSQL("alter table startup_list add column 'device_manufacturer' text NOT NULL DEFAULT ''")
//                database.execSQL("alter table startup_list add column 'device_brand' text NOT NULL DEFAULT ''")
            }

        }

    }
}