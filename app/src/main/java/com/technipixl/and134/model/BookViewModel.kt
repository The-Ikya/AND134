package com.technipixl.and134.model

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class BookViewModel(application: Application = Application()) : AndroidViewModel(application) {

	private var db: DataBase = DataBase.getDB(getApplication<Application>().applicationContext)

	private var _allItems = MutableLiveData<List<BookGenreLink>>(listOf())
	val allItems: LiveData<List<BookGenreLink>> get() = _allItems

	private var _books = db.bookDao().getAllBooks().asLiveData()
	val books: LiveData<List<Book>> get() = _books

	private var _genres = MutableLiveData<List<Genre>>(listOf())
	val genres: LiveData<List<Genre>> get() = _genres

	init {
		viewModelScope.launch(IO) {
			if (db.genreDao().getGenreCount() == 0) {
				db.genreDao().insert(Genre(name = "Horror"))
				db.genreDao().insert(Genre(name = "Fiction"))
				db.genreDao().insert(Genre(name = "Adventure"))
				db.genreDao().insert(Genre(name = "Mystery"))
				db.genreDao().insert(Genre(name = "Thriller"))
				db.genreDao().insert(Genre(name = "Historical"))
				db.genreDao().insert(Genre(name = "Romance"))
				db.genreDao().insert(Genre(name = "Science Fiction"))
				db.genreDao().insert(Genre(name = "Fantasy"))
				db.genreDao().insert(Genre(name = "Western"))
			}
		}

		viewModelScope.launch(IO) {
			if (db.bookDao().getBookCount() > 0) {
				db.bookDao().insert(Book(
					author = "Mavrikd",
					title = "Mavrik en vacancesfg",
					pageCount = 2,
					summary = "Mavrik ne prend pas de vacances !"
				))
			}
		}
//		_books = db.bookDao().getAllBooks().asLiveData()
	}

	fun getAllBooks() = db.bookDao().getAllBooks()
}

fun <T> MutableLiveData<T>.notifyObserver() {
	this.value = this.value
}