package com.johnm.persistencemanagementmod.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.johnm.persistencemanagementmod.daos.AccountBankDao
import com.johnm.persistencemanagementmod.daos.TransactionBankDao
import com.johnm.persistencemanagementmod.daos.UserDao
import com.johnm.persistencemanagementmod.entities.AccountBankEntity
import com.johnm.persistencemanagementmod.entities.TransactionBankEntity
import com.johnm.persistencemanagementmod.entities.UserEntity


@Database(
    entities = [
        UserEntity::class,
        AccountBankEntity::class,
        TransactionBankEntity::class
    ],
    version = BankDataBase.VERSION,
    exportSchema = false
)
abstract class BankDataBase : RoomDatabase() {


    abstract fun getUserDao(): UserDao
    abstract fun getAccountBankDao(): AccountBankDao
    abstract fun getTransactionBankDao(): TransactionBankDao

    companion object {

        const val VERSION = 1

        private const val DATABASE_NAME = "BANK_DEVELONMENT"

        var INSTANCE: BankDataBase? = null


        fun getDataBase(context: Context): BankDataBase? {
            if (INSTANCE == null) {
                synchronized(BankDataBase::class.java) {
                    if (INSTANCE == null) {

                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            BankDataBase::class.java,
                            DATABASE_NAME
                        )
                            .addCallback(sRoomDatabaseCallback)
                            .setJournalMode(JournalMode.TRUNCATE)
                            .build()

                    }
                }

            }
            return INSTANCE
        }

        fun getOpenDataBase() {
            INSTANCE?.isOpen
        }

        fun getCloseDataBase() {
            INSTANCE?.close()
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {}
    }


}