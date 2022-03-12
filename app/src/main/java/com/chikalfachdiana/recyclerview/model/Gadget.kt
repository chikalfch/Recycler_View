package com.chikalfachdiana.recyclerview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gadget(
    val gadgetName: String?,
    val gadgetimages: Int
): Parcelable

