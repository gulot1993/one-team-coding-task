package com.example.one_team_coding_challenge.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.one_team_coding_challenge.model.entity.ActivityEntity
import com.example.one_team_coding_challenge.model.entity.LevelEntity
import com.example.one_team_coding_challenge.model.entity.LevelWithActivityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TemperDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLevel(level: LevelEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addActivities(activities: List<ActivityEntity>)

    @Transaction
    suspend fun addLevelWithActivities(level: LevelEntity, activities: List<ActivityEntity>) {
        val levelId = addLevel(level = level)
        activities.forEach { item ->
            item.levelId = levelId
        }
        addActivities(activities = activities)
    }

    @Transaction
    @Query("SELECT * FROM level")
    fun loadLevelWithActivities(): Flow<List<LevelWithActivityEntity>>

}