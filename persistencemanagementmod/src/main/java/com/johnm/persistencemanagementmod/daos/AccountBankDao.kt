package com.johnm.persistencemanagementmod.daos

import androidx.room.Dao
import com.johnm.persistencemanagementmod.entities.AccountBankEntity

@Dao
abstract class AccountBankDao : GenericDao<AccountBankEntity>

