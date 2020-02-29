package com.xing.jetpack.room

import android.content.Context
import androidx.room.Room

class AppDatabaseManager {

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "Sample.db")
                .build()
    }
}