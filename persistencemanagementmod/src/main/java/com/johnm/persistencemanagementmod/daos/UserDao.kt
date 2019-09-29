package com.johnm.persistencemanagementmod.daos

import androidx.room.Dao
import com.johnm.persistencemanagementmod.entities.UserEntity

@Dao
abstract class UserDao : GenericDao<UserEntity>