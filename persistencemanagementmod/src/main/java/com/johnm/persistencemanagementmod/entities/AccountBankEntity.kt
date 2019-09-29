package com.johnm.persistencemanagementmod.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = AccountBankEntity.TABLE_NAME
)
class AccountBankEntity(
    @NonNull
    @ColumnInfo(name = N_ACCOUNT_BANK_COLUMN_NAME)
    var numAccoBank: Int,
    @NonNull
    @ColumnInfo(name = TYPE_ACCOUNT_COLUMN_NAME)
    var typeAccoBank: Int
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ACCOUNT_BANK_ID_COLUMN_NAME)
    var accountId: Int = 0

    companion object {
        const val TABLE_NAME = "ACCOUNT_BANK"
        const val ACCOUNT_BANK_ID_COLUMN_NAME = "ACCOUNT_BANK_ID"
        const val N_ACCOUNT_BANK_COLUMN_NAME = "N_ACCOUNT_BANK"
        const val TYPE_ACCOUNT_COLUMN_NAME = "TYPE_ACCOUNT"
    }
}