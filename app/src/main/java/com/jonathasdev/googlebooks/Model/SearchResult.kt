package com.jonathasdev.googlebooks.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class SearchResult (
    val items: List<Volume>?
        )