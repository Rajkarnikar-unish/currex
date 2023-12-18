package com.rajkarnikarunish.currex.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.rajkarnikarunish.currex.database.MyConverter

@Entity(
    tableName = "ratesResponse"
)
@TypeConverters(MyConverter::class)
data class RatesResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @SerializedName("base_code")
    val baseCode: String,
    @SerializedName("conversion_rates")
    val conversionRates: Map<String, Double>,
    @SerializedName("documentation")
    val documentation: String,
    @SerializedName("result")
    val result: String,
    @SerializedName("terms_of_use")
    val termOfUse: String,
    @SerializedName("time_last_update_unix")
    val timeLastUpdateUnix: Int,
    @SerializedName("time_last_update_utc")
    val timeLastUpdateUtc: String,
    @SerializedName("time_next_update_unix")
    val timeNextUpdateUnix: Int,
    @SerializedName("time_next_update_utc")
    val timeNextUpdateUtc: String
)