package com.example.booksearch.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksearch.network.Book
import com.example.booksearch.network.BooksApi
import com.example.booksearch.network.SearchResult
import kotlinx.coroutines.launch

enum class BooksApiStatus { LOADING, ERROR, DONE }

class SearchViewModel : ViewModel() {

    private var _status = MutableLiveData<BooksApiStatus>()
    val status: LiveData<BooksApiStatus>
        get() = _status

    private var _searchText = MutableLiveData<String>()
    val searchText: LiveData<String>
        get() = _searchText

    private var _searchResult = MutableLiveData<SearchResult>()
    val searchResult: LiveData<SearchResult>
        get() = _searchResult

    init {
        _searchResult.value = SearchResult(0, ArrayList())
        // searchBooks()
    }

    private fun searchBooks() {
        if (searchText.value.toString().isNotEmpty()) {

            viewModelScope.launch {
                _status.value = BooksApiStatus.LOADING

                try {
                    _searchResult.value =
                        BooksApi.retrofitService.getBooks(searchText.value.toString())
                    _status.value = BooksApiStatus.DONE
                } catch (t: Throwable) {
                    _status.value = BooksApiStatus.ERROR
                    _searchResult.value = SearchResult(0, ArrayList())
                }

            }

        }
    }

    fun updateSearchText(text: String) {
        _searchText.value = text
    }

    fun newSearch() {
        searchBooks()
    }

    fun displayBookDetail(book: Book) {
        TODO("Not yet implemented")
    }


}