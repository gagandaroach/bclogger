package tech.daroach.bclogger.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import tech.daroach.bclogger.db.Cycle
import tech.daroach.bclogger.db.LogDatabase
import java.util.*

class CycleViewModel(application: Application) : AndroidViewModel(application) {
    companion object {
        const val TAG = "trick bike > mach bike" //For Logging
        val DEFAULT_GOAL: Calendar = Calendar.getInstance()
    }

    init {
        DEFAULT_GOAL.set(0, 0, 0, 7, 0, 0) // 7 AM
    }

    //initiate database
    private val logDataBase: LogDatabase = LogDatabase.getInstance(application)
    //grab cycleDAO
    private val cycleDAO = logDataBase.CycleDAO()

    //count observer
    private val cycleCount = cycleDAO.getCycleCount()

    /**
     * evaluates true if no cycles have ever been started
     */
    fun emptyCycleList(): LiveData<Boolean> {
        return Transformations.map(cycleCount) {
            count ->
            count==0
        }
    }

    /**
     * creates a new cycle and posts it to the db
     * assumes start date of today, and goal time of default goal
     */
    fun startNewCycleToday() {
        startNewCycle(Calendar.getInstance())
    }

    private fun startNewCycle(startDate: Calendar, goalTime: Calendar = DEFAULT_GOAL) {
        val newCycle = Cycle(_startDate = startDate, _goalTime = goalTime)
        Log.d(TAG, "Stored db entry $newCycle")
        cycleDAO.insert(newCycle)
    }
}

// commented out april 13 2019
//Hello my name is cassie and this is the part where I annoy gagan with all the typing,
//        typing going on and on and on and on. and on and on and on and on. this chair is always so high
//        up when I come over here and sit down. why are all the words in this comment
//        thread showing up with underlined red. none of this is misspelled. this is
//        misleading to the user. excuse me. that is so rude. dont you know that the user
//        is v important to the interaction at hand. i am very confused and am doubting
//        my comment because of the agressiveness of the red underline. i demand that
//        these red streaks be removed immediately, as i believe most others feel as
//        strongly  as i do. good day. thank you for your time. it is appreciated.
//        xoxo, redshoecassage.