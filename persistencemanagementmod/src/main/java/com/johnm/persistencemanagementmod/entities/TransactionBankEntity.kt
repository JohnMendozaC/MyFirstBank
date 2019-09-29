package com.johnm.persistencemanagementmod.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = TransactionBankEntity.TABLE_NAME
)
class TransactionBankEntity(
    @NonNull
    @ColumnInfo(name = DATE_TRANS_BANK_COLUMN_NAME)
    var dateTransBank: Long,
    @NonNull
    @ColumnInfo(name = DESC_TRANS_COLUMN_NAME)
    var descTransBank: String,
    @NonNull
    @ColumnInfo(name = VAL_TRANS_COLUMN_NAME)
    var valueTransBank: Double

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = TRANS_BANK_ID_COLUMN_NAME)
    var transferId: Int = 0

    companion object {
        const val TABLE_NAME = "TRANSACTION_BANK"
        const val TRANS_BANK_ID_COLUMN_NAME = "TRANS_BANK_ID"
        const val DATE_TRANS_BANK_COLUMN_NAME = "DATE_TRANS_BANK"
        const val DESC_TRANS_COLUMN_NAME = "DESC_TRANS_BANK"
        const val VAL_TRANS_COLUMN_NAME = "VAL_TRANS_BANK"
    }
}