package tech.daroach.bclogger.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.provider.BaseColumns
import tech.daroach.bclogger.db.LogEntry.Companion.LOG_TABLE_NAME
import java.util.*


/**
 * simple data class
 * stores date: Long (date.getTime())
 */
@Entity(tableName = LOG_TABLE_NAME)

/**
 * uuid randomly generated
 * date defaults to current time
 */
class LogEntry constructor(
    _uid: Int = 0, _date: Long = DateConverter.toTimestamp(Date())
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMNID_ID)
    var uid: Int = _uid
    @ColumnInfo(name = COLUMNID_DATE)
    var date: Long = _date

    /**
     * contains public constants
     */
    companion object
    {
        const val LOG_TABLE_NAME: String = "logtable"
        const val COLUMNID_DATE: String = "columndatelong"
        const val COLUMNID_ID: String = "columnid"
    }

    override fun toString(): String
    {
        return "Date: $date UID: $uid"
    }
}