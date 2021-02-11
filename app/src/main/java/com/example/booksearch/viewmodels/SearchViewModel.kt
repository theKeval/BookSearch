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

class SearchViewModel: ViewModel() {

    private var _status = MutableLiveData<BooksApiStatus>()
    val status: LiveData<BooksApiStatus>
        get() = _status

    private var _searchText = MutableLiveData<String>()
    val searchText: LiveData<String>
        get() =_searchText

    private var _searchResult = MutableLiveData<SearchResult>()
    val searchResult: LiveData<SearchResult>
        get() = _searchResult

    init {
        searchBooks(searchText.value)
    }

    private fun searchBooks(text: String?) {
        if (!text.isNullOrEmpty()) {

            viewModelScope.launch {
                _status.value = BooksApiStatus.LOADING

                try {
                    _searchResult.value = BooksApi.retrofitService.getBooks(text)
                    _status.value = BooksApiStatus.DONE
                }
                catch (t: Throwable) {
                    _status.value = BooksApiStatus.ERROR
                    _searchResult.value = SearchResult(0, ArrayList())
                }

            }

        }
    }


    fun newSearch(text: String) {
        searchBooks(text)
    }

    fun displayBookDetail(book: Book) {
        TODO("Not yet implemented")
    }


}