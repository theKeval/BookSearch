package com.example.booksearch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearch.databinding.BooklistItemViewBinding
import com.example.booksearch.network.Book

class BookListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Book, BookListAdapter.BookViewHolder>(BookDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(BooklistItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val bookItem = getItem(position)
        holder.bind(bookItem)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(bookItem)
        }
    }


    class BookViewHolder(private var binding: BooklistItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.book = book
            binding.executePendingBindings()
        }
    }

    companion object BookDiffCallback : DiffUtil.ItemCallback<Book>() {
        // change in the way we compare is because here we don't need to update the data
        // while searched once.
        // we can add any sort of logic to compare old and new item..
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            // === to compare the reference of the object
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class OnClickListener(val clickListener: (book: Book) -> Unit) {
        fun onClick(book: Book) = clickListener(book)
    }

}