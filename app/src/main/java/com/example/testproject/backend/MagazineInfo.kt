package com.example.testproject.backend

import com.google.gson.annotations.SerializedName

data class Magazine(
    @SerializedName("date_released")
    val dateReleased: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img_url")
    val imgUrl: String,
    @SerializedName("pdf_url")
    val pdfUrl: String,
    @SerializedName("title")
    val title: String
)