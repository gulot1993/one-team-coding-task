package com.example.one_team_coding_challenge.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.one_team_coding_challenge.model.domain.Activity

@Entity(tableName = "activity")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("activityId") val id: Long = 0,
    @ColumnInfo("title") val title: String = "",
    @ColumnInfo("description") val description: String = "",
    @ColumnInfo("lockedIconUrl") val lockedIconUrl: String = "",
    @ColumnInfo("iconUrl") val iconUrl: String = "",
    @ColumnInfo("levelId") var levelId: Long? = 0
) {
    companion object {
        fun ActivityEntity.toDomain(isLocked: Boolean): Activity {
            return with(this) {
                Activity(
                    icon = if (isLocked) lockedIconUrl else iconUrl,
                    description = description,
                    title = title
                )
            }
        }
    }
}
