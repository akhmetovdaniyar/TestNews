package com.example.testnews.data.model

import com.google.gson.annotations.SerializedName

data class NewsSource (
    @SerializedName("status") val status : String,
    @SerializedName("totalResults") val totalResults : Int,
    @SerializedName("articles") val articles : List<Articles>
    )