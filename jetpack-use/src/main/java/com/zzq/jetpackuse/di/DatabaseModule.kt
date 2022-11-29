package com.zzq.jetpackuse.di

import android.content.Context
import com.zzq.jetpackuse.app.JetpackDatabase
import com.zzq.jetpackuse.db.dao.StartupDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 提供第三方库如Retrofit初始化后的入口，全局唯一
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): JetpackDatabase {
        return JetpackDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideStartupDao(appDatabase: JetpackDatabase): StartupDao {
        return appDatabase.startupDao
    }
}