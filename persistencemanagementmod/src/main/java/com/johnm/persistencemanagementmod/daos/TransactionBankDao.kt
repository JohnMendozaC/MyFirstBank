package com.johnm.persistencemanagementmod.daos

import androidx.room.Dao
import com.johnm.persistencemanagementmod.entities.TransactionBankEntity

@Dao
abstract class TransactionBankDao : GenericDao<TransactionBankEntity>