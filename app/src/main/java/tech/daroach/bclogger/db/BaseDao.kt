package tech.daroach.bclogger.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

/**
 * base dao class
 */
@Dao
interface BaseDao<in T> {
    @Insert
    fun insert(t: T)
    @Update
    fun update(t: T)
    @Delete
    fun delete(t: T)
}