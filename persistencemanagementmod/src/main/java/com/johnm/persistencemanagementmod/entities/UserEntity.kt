package com.johnm.persistencemanagementmod.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = UserEntity.TABLE_NAME
)
class UserEntity(
    @NonNull
    @ColumnInfo(name = NAME_COLUMN_NAME)
    var nameUser: String,

    @NonNull
    @ColumnInfo(name = PASS_COLUMN_NAME)
    var passUser: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = USER_ID_COLUMN_NAME)
    var userId: Int = 0

    companion object {
        const val TABLE_NAME = "USER"
        const val USER_ID_COLUMN_NAME = "USER_ID"
        const val NAME_COLUMN_NAME = "NAME"
        const val PASS_COLUMN_NAME = "PASS"
    }
}