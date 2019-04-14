package tech.daroach.bclogger.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Daroach on 7/8/18.
 */

/**
 * database access object for [Cycle]
 */
@Dao
interface CycleDAO : BaseDao<Cycle>
{
    @Query("SELECT COUNT(*) FROM ${Cycle.CYCLE_TABLE_NAME}")
    fun getCycleCount(): LiveData<Int>
}