package com.rajkarnikarunish.currex.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rajkarnikarunish.currex.database.Rates
import com.rajkarnikarunish.currex.models.RatesResponse

@Dao
interface CurrexDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertToRates(rates: Rates) : Long
    
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsertResponse(ratesResponse: RatesResponse): Long
}