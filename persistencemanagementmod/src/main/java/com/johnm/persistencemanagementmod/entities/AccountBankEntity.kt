package com.johnm.persistencemanagementmod.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = AccountBankEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = [UserEntity.USER_ID_COLUMN_NAME],
            childColumns = [AccountBankEntity.USER_ID_COLUMN_NAME]
        )
    ]
)
class AccountBankEntity(
    @NonNull
    @ColumnInfo(name = USER_ID_COLUMN_NAME)
    var userId: Int = 0,
    @NonNull
    @ColumnInfo(name = N_ACCOUNT_BANK_COLUMN_NAME)
    var numAccoBank: Int,
    @NonNull
    @ColumnInfo(name = TYPE_ACCOUNT_COLUMN_NAME)
    var typeAccoBank: Int,
    @NonNull
    @ColumnInfo(name = ACCOUNT_BALANCE_COLUMN_NAME)
    var balanceAccountBank: Double
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ACCOUNT_BANK_ID_COLUMN_NAME)
    var accountId: Int = 0

    companion object {
        const val TABLE_NAME = "ACCOUNT_BANK"
        const val ACCOUNT_BANK_ID_COLUMN_NAME = "ACCOUNT_BANK_ID"
        const val N_ACCOUNT_BANK_COLUMN_NAME = "N_ACCOUNT_BANK"
        const val TYPE_ACCOUNT_COLUMN_NAME = "TYPE_ACCOUNT"
        const val ACCOUNT_BALANCE_COLUMN_NAME = "ACCOUNT_BALANCE"
        const val USER_ID_COLUMN_NAME = "USER_ID"
    }
}