package com.example.financeapp

import com.google.gson.annotations.SerializedName

import com.beust.klaxon.*

//private val klaxon = Klaxon()
//
//data class Trade(
//    val data: String?,
//    val type: String
//) {
//    public fun toJson() = klaxon.toJsonString(this)
//
//    companion object {
//        public fun fromJson(json: String) = klaxon.parse<Trade>(json)
//    }
//}
//
//data class Datum (
//    val p: Double,
//    val s: String,
//    val t: Long,
//    val v: Double
//)
data class Trade (

    @SerializedName("data") val data : List<TradeData>,
    @SerializedName("type") val type : String
)