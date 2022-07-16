package com.jonathasdev.googlebooks.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Volume (
    val id: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
        ) : Parcelable