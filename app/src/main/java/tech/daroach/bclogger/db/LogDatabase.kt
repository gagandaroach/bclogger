package tech.daroach.bclogger.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

/**
 * Created by Daroach on 7/8/18.
 */

@Database(entities = [(LogEntry::class)], version = 2, exportSchema = false)
abstract class LogDatabase : RoomDatabase() {
    abstract fun logEntryDAO(): LogEntryDAO

    companion object {

        /**
         * the only instance
         */
        private var sInstance: LogDatabase? = null

        /**
         * Gets the singleton instance of LogDatabase
         *
         * @param context The context.
         * @return The singleton instance of LogDatabase
         */
        @Synchronized
        fun getInstance(context: Context): LogDatabase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, LogDatabase::class.java, "logdb")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return sInstance as LogDatabase
        }
    }
}