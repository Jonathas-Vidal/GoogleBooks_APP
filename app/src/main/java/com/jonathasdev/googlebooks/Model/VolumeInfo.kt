package com.jonathasdev.googlebooks.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VolumeInfo (
    val title: String?,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publisherDate: String?,
    val pageCount: Int?,
    val imageLinks: ImageLinks?
        ) : Parcelable

