package com.rajkarnikarunish.currex.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "rates"
)
data class Rates (
    @PrimaryKey
    val currency: String,
    val rate: Double
)