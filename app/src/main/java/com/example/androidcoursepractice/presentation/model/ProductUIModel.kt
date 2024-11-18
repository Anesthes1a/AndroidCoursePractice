package com.example.androidcoursepractice.presentation.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import com.example.androidcoursepractice.domain.entity.RatingEntity
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class ProductUIModel (
    val id: Long = 0L,
    val title: String = "Empty",
    val price: String = "Empty",
    val category: String = "Empty",
    val description: String = "Empty",
    val image: String = "Empty",
    val rate: String = "Empty",
    val rateCount: String = "Empty",
) :Parcelable