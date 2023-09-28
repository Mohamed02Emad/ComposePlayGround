package com.androiddevs.mvvmnewsapp.data.models

import androidx.annotation.Keep
import java.io.Serializable


@Keep
data class Source(
    val id: String,
    val name: String
) : Serializable