package tech.daroach.bclogger.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
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
class LogEntry constructor (
    _lid: Int = 0, _date: Calendar = Calendar.getInstance(), _cycleIndex: Int = 29, _cid: Int = 0
)

{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMNID_ID)
    var LID: Int = _lid
    @ColumnInfo(name = COLUMNID_DATE)
    var date: Calendar = _date
    @ColumnInfo(name = COLUMNID_CYCLE_INDEX)
    var cycleIndex: Int = _cycleIndex
    @ForeignKey(entity = Cycle::class, parentColumns = [Cycle.COLUMNID_CID], childColumns = [COLUMNID_CID])
    var CID: Int = _cid

    /**
     * contains public constants
     */
    companion object
    {
        const val LOG_TABLE_NAME: String = "logtable"
        const val COLUMNID_DATE: String = "punchdate"
        const val COLUMNID_ID: String = "LID"
        const val COLUMNID_CID: String = "CID"
        const val COLUMNID_CYCLE_INDEX: String = "cycleindex"
    }

    override fun toString(): String
    {
        return "LID: $LID Date: $date "
    }
}