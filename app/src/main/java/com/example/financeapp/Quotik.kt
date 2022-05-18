package com.example.financeapp

import com.squareup.moshi.Json
import java.io.Serializable

data class Quotik(
    var title : kotlin.String,

    @Json(name = "o")
    val o: kotlin.Float? = null,

    /* High price of the day */
    @Json(name = "h")
    val h: kotlin.Float? = null,

    /* Low price of the day */
    @Json(name = "l")
    val l: kotlin.Float? = null,

    /* Current price */
    @Json(name = "c")
    val c: kotlin.Float? = null,

    /* Previous close price */
    @Json(name = "pc")
    val pc: kotlin.Float? = null,

    /* Change */
    @Json(name = "d")
    val d: kotlin.Float? = null,

    /* Percent change */
    @Json(name = "dp")
    val dp: kotlin.Float? = null

) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

