package com.example.booksearch.network

import android.os.Parcelable
import android.view.textclassifier.TextLinks
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResult(

    val totalItems: Int,
    val items: List<Book>

) : Parcelable {

}

@Parcelize
data class Book(
    val id: String,
    val selfLink: String,

    @Json(name = "volumeInfo")
    val bookInfo: BookInfo,

    val saleInfo: BookSaleInfo

) : Parcelable {

}

@Parcelize
data class BookInfo(
    val title: String,
    val subTitle: String,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val pageCount: Int,
    val averageRating: Double,
    val ratingsCount: Int,

    @Json(name = "imageLinks")
    val thumbnailLinks: ThumbnailLinks,

    val language: String,
    val infoLink: String
) : Parcelable {

}

@Parcelize
data class ThumbnailLinks(
    val thumbnail: String,
    val smallThumbnail: String
) : Parcelable {

}

@Parcelize
data class BookSaleInfo(
    val country: String,

    @Json(name = "listPrice")
    val actualPrice: BookPrice,

    @Json(name = "retailPrice")
    val sellingPrice: BookPrice

) : Parcelable {

}

@Parcelize
data class BookPrice(
    val amount: Double,
    val currencyCode: String
) : Parcelable {

}