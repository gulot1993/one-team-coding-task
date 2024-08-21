package com.example.one_team_coding_challenge.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.one_team_coding_challenge.database.dao.TemperDao
import com.example.one_team_coding_challenge.model.entity.ActivityEntity
import com.example.one_team_coding_challenge.model.entity.LevelEntity

@Database(version = 1, entities = [LevelEntity::class, ActivityEntity::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun temperDao(): TemperDao

    companion object {
        const val db_name = "app_db"

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        db_name
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}