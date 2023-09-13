package com.example.udemy_newsapiclient.data.model


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    val name: String
)