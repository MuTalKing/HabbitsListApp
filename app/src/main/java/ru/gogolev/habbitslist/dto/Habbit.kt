package ru.gogolev.habbitslist.dto

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Habbit(val name: String, val description: String): Parcelable
