package com.technipixl.and134.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technipixl.and134.model.Genre

@Dao
interface GenreDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(genre: Genre)

	@Query("SELECT * FROM genre")
	fun getAllGenres() : LiveData<List<Genre>>

	@Query("SELECT COUNT(*) FROM genre")
	fun getGenreCount() : Int
}