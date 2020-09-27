package br.cericatto.gok.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GokProperty(
    val spotlight: List<SpotlightProperty>,
    val products: List<ProductProperty>,
    val cash: CashProperty
): Parcelable

@Parcelize
data class SpotlightProperty(
    val name: String,
    val bannerURL: String,
    val description: String
): Parcelable

@Parcelize
data class ProductProperty(
    val name: String,
    val imageURL: String,
    val description: String
): Parcelable

@Parcelize
data class CashProperty(
    val title: String,
    val bannerURL: String,
    val description: String
): Parcelable