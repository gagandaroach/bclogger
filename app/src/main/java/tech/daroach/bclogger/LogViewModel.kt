package tech.daroach.bclogger

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import android.util.Log
import tech.daroach.bclogger.db.LogDatabase
import tech.daroach.bclogger.db.LogEntry

/**
 * contains list of LogEntries
 *
 * pass in context for application
 */
class LogViewModel(application: Application) : AndroidViewModel(application) {
    companion object {
        const val TAG = "lebron left cleveland"
    }

    //initiate database and get log entries live data list
    private val logDataBase: LogDatabase = LogDatabase.getInstance(application)
    private val logEntriesList: LiveData<List<LogEntry>>

    init {
        logEntriesList = logDataBase.logEntryDAO().getAllInOrder()
    }

    private val mostRecentLog: LiveData<LogEntry>

    init {
        mostRecentLog = logDataBase.logEntryDAO().getMostRecentEntry()
    }

    /**
     * inserts log into database
     */
    fun postLogEntry(logEntry: LogEntry) {
        logDataBase.logEntryDAO().insertAll(arrayOf(logEntry))
    }

    /**
     * post a fresh log to the database
     *
     * and log it
     */
    fun postLogEntryWithCurrentDate(): LogEntry {
        val entry = LogEntry()
        Log.d(TAG, "Stored db entry $entry")
        postLogEntry(entry)
        return entry
    }

    fun getMostRecentLogEntry() = mostRecentLog as LiveData<LogEntry>

    fun getLastFive() = logDataBase.logEntryDAO().getCountRecentEntries(5)

    fun getPillCount(): LiveData<Int> = logDataBase.logEntryDAO().getPillCount()

    fun getAllEntries(): LiveData<List<LogEntry>> {
        return logEntriesList
    }

    fun deleteAllLogs() {
        logDataBase.clearAllTables()
    }

    fun deleteMostRecentLogEntry() {
        val mostRecEntry = getMostRecentLogEntry()
        logDataBase.logEntryDAO().delete(mostRecEntry.value!!)
    }

}
