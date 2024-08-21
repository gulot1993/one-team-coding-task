package com.example.one_team_coding_challenge.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "level")
data class LevelEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("levelId") val id: Long = 0,
    @ColumnInfo("title") val title: String = "",
    @ColumnInfo("description") val description: String = ""
)
