package com.example.one_team_coding_challenge.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.one_team_coding_challenge.model.domain.Level
import com.example.one_team_coding_challenge.model.entity.ActivityEntity.Companion.toDomain

@Entity(tableName = "level")
data class LevelEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("levelId") val id: Long = 0,
    @ColumnInfo("title") val title: String = "",
    @ColumnInfo("description") val description: String = "",
    @ColumnInfo("state") val state: String = "",
    @ColumnInfo("level") val level: String = "",
) {
    companion object {
        fun LevelEntity.toDomain(activities: List<ActivityEntity>): Level {
            return with(this) {
                Level(
                    title = title,
                    description = description,
                    activities = activities.map { it.toDomain(state == "LOCKED") },
                    state = state,
                    level = level
                )
            }
        }
    }
}
