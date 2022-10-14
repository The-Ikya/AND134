package com.technipixl.and134.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technipixl.and134.model.BookGenreLink

@Dao
interface BookGenreDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(book: BookGenreLink)

	@Query("SELECT * FROM bookgenrelink")
	fun getAll() : LiveData<List<BookGenreLink>>
}