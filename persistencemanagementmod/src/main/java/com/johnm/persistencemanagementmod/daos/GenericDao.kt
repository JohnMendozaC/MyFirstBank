package com.johnm.persistencemanagementmod.daos


import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface GenericDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //TODO Jimena Rojas cambiar por ABORT
    fun insertRow(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertRows(entity: List<T>): Array<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateRows(entity: List<T>): Array<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(entity: T): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRow(entity: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRows(entity: List<T>)

    @Delete
    fun deleteRow(entity: T): Int
}