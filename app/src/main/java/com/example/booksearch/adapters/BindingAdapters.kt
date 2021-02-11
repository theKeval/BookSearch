package com.example.booksearch.adapters

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.booksearch.R
import com.example.booksearch.network.Book
import com.example.booksearch.network.BookInfo

@BindingAdapter("imageUrl")
fun bindImage(thumbnail: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(thumbnail.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(thumbnail)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(bookList: RecyclerView, books: List<Book>) {
    val adapter = bookList.adapter as BookListAdapter
    adapter.submitList(books)
}

@BindingAdapter("setRating")
fun TextView.bindRating(bookInfo: BookInfo) {
    // ratingText.text = bookInfo.averageRating.toString() + ", " + bookInfo.ratingsCount + " reviews"

    bookInfo?.apply {
        text = bookInfo.averageRating.toString() + ", " + bookInfo.ratingsCount + " reviews"
    }
}

@BindingAdapter("setPrice")
fun TextView.bindPrice(price: Double) {
    // priceText.text = price.toString()
    price.apply {
        text = price.toString()
    }
}