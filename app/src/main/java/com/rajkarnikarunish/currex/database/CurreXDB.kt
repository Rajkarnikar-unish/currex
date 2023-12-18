package com.rajkarnikarunish.currex.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rajkarnikarunish.currex.database.dao.CurrexDao
import com.rajkarnikarunish.currex.models.RatesResponse

@Database(
    entities = [Rates::class, RatesResponse::class],
    version = 1,
)
abstract class CurreXDB : RoomDatabase() {
    abstract fun getCurrexDao() : CurrexDao

    companion object {
        @Volatile
        private var instance: CurreXDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it}
        }

        public fun createDatabase(context: Context)  = Room.databaseBuilder(
            context.applicationContext,
            CurreXDB::class.java,
            "currex_db.db"
        ).build()
    }
}