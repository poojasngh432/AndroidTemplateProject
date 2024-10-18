package com.droidspiration.androidtemplateproject.data

import com.google.gson.annotations.SerializedName

data class Museum (
    val name: String,
    @SerializedName("image_url") val imageUrl: String
)
