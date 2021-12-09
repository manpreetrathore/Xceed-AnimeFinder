package com.example.android.herewego


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("anilist")
    val anilist: Int,
    @SerializedName("episode")
    val episode: Int,
    @SerializedName("filename")
    val filename: String,
    @SerializedName("from")
    val from: Double,
    @SerializedName("image")
    val image: String,
    @SerializedName("similarity")
    val similarity: Double,
    @SerializedName("to")
    val to: Double,
    @SerializedName("video")
    val video: String
)