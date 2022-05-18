package com.example.financeapp

import com.google.gson.annotations.SerializedName

data class TradeData(

    @SerializedName("p") val p : Double? ,
    @SerializedName("s") val s : String? ,
    @SerializedName("t") val t : Long?,
    @SerializedName("v") val v : Double?


)
