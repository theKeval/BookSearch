package com.example.booksearch.network

import android.os.Parcelable
import android.view.textclassifier.TextLinks
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResult(

    val totalItems: Int = 0,
    val items: List<Book> = ArrayList()

) : Parcelable {

}

@Parcelize
data class Book(
    val id: String = "",
    val selfLink: String = "",

    @Json(name = "volumeInfo")
    val bookInfo: BookInfo = BookInfo(),

    val saleInfo: BookSaleInfo = BookSaleInfo()

) : Parcelable {

}

@Parcelize
data class BookInfo(
    val title: String = "",
    val subtitle: String = "",
    val authors: List<String> = ArrayList(),
    val publisher: String = "",
    val publishedDate: String = "",
    val description: String = "",
    val pageCount: Int = 0,
    val averageRating: Double = 0.toDouble(),
    val ratingsCount: Int = 0,

    @Json(name = "imageLinks")
    val thumbnailLinks: ThumbnailLinks = ThumbnailLinks("", ""),

    val language: String = "",
    val infoLink: String = ""
) : Parcelable {

}

@Parcelize
data class ThumbnailLinks(
    val thumbnail: String = "",
    val smallThumbnail: String = ""
) : Parcelable {

}

@Parcelize
data class BookSaleInfo(
    val country: String = "",

    @Json(name = "listPrice")
    val actualPrice: BookPrice = BookPrice(0.toDouble(), ""),

    @Json(name = "retailPrice")
    val sellingPrice: BookPrice = BookPrice(0.toDouble(), "")

) : Parcelable {

}

@Parcelize
data class BookPrice(
    val amount: Double = 0.toDouble(),
    val currencyCode: String = ""
) : Parcelable {

}