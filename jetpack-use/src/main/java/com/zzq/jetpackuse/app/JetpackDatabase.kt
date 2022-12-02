package com.zzq.jetpackuse.app

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zzq.jetpackuse.db.dao.AppExceptionDao
import com.zzq.jetpackuse.db.dao.StartupDao
import com.zzq.jetpackuse.db.entity.AppExceptionPO
import com.zzq.jetpackuse.db.entity.StartupPO

@Database(
    entities = [StartupPO::class, AppExceptionPO::class],
    exportSchema = true,
    version = 3,
    autoMigrations = [AutoMigration(from = 1, to = 2), AutoMigration(from = 2, to = 3)]
)
abstract class JetpackDatabase : RoomDatabase() {
    abstract val startupDao: StartupDao
    abstract val appExceptionDao: AppExceptionDao

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
                        .addMigrations(MIGRATION_2_3)
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
                //错误写法
                //database.execSQL("alter table startup_list add column 'device_manufacturer' text NOT NULL DEFAULT ''")
                //正确写法
                database.execSQL("ALTER TABLE startup_list ADD COLUMN system_version TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE startup_list ADD COLUMN system_model TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE startup_list ADD COLUMN device_manufacturer TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE startup_list ADD COLUMN device_brand TEXT NOT NULL DEFAULT ''")
            }

        }

        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //创建表
                database.execSQL("create table app_exception (id integer PRIMARY KEY NOT NULL, type text NOT NULL, message text NOT NULL, time_millis INTEGER NOT NULL)")
            }

        }

    }
}