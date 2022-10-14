package com.technipixl.and134.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technipixl.and134.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(book: Book)

	@Query("SELECT * FROM book")
	fun getAllBooks() : Flow<List<Book>>

	@Query("SELECT COUNT(*) FROM book")
	fun getBookCount() : Int
}