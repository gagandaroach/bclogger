package tech.daroach.bclogger.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tech.daroach.bclogger.db.Cycle.Companion.CYCLE_TABLE_NAME
import java.util.*


/**
 * simple data class
 * stores date: Long (date.getTime())
 */
@Entity(tableName = CYCLE_TABLE_NAME)

/**
 * uuid randomly generated
 * date defaults to current time
 */
class Cycle constructor (
    _CID: Int = 0,
    _startDate: Calendar = Calendar.getInstance(),
    _goalTime: Calendar = Calendar.getInstance()
)

{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMNID_CID)
    var CID: Int = _CID
    @ColumnInfo(name = COLUMNID_START_DATE)
    var startDate: Calendar = _startDate
    @ColumnInfo(name = COLUMNID_GOAL_TIME)
    var goalTime: Calendar = _goalTime

    /**
     * contains public constants
     */
    companion object
    {
        const val CYCLE_TABLE_NAME: String = "cycletable"
        const val COLUMNID_START_DATE: String = "startdate"
        const val COLUMNID_CID: String = "cid"
        const val COLUMNID_GOAL_TIME: String = "goal"
    }

    override fun toString(): String
    {
        return "CYCLE | CID: $CID, StartDate: $startDate, GoalTime: $goalTime"
    }
}