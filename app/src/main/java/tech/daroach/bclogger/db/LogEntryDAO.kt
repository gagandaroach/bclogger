package tech.daroach.bclogger.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Daroach on 7/8/18.
 */

/**
 * database access object for [LogEntry]
 */
@Dao
interface LogEntryDAO : BaseDao<LogEntry>
{

    @Query("SELECT * FROM ${LogEntry.LOG_TABLE_NAME} ORDER BY ${LogEntry.COLUMNID_ID} DESC")
    fun getAllInOrder(): LiveData<List<LogEntry>>

    @Query("SELECT * FROM ${LogEntry.LOG_TABLE_NAME} ORDER BY ${LogEntry.COLUMNID_ID} DESC LIMIT :count")
    fun getCountRecentEntries(count: Int): LiveData<List<LogEntry>>

    @Insert
    fun insertAll(entries: Array<LogEntry>)

    @Query("DELETE FROM ${LogEntry.LOG_TABLE_NAME}")
    fun eraseAllEntries()

    @Query("SELECT * FROM ${LogEntry.LOG_TABLE_NAME} ORDER BY ${LogEntry.COLUMNID_ID} DESC LIMIT 1")
    fun getMostRecentEntry(): LiveData<LogEntry>

    @Query("SELECT Count(*) FROM ${LogEntry.LOG_TABLE_NAME}")
    fun getPillCount(): LiveData<Int>
}