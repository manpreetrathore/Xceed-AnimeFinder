package com.example.android.herewego


import com.google.gson.annotations.SerializedName

data class MyData(
    @SerializedName("error")
    val error: String,
    @SerializedName("frameCount")
    val frameCount: Int,
    @SerializedName("result")
    val result: List<Result>
)