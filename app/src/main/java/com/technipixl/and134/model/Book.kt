package com.technipixl.and134.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
	@PrimaryKey(autoGenerate = true)
	val bookId: Long = 0,
	val author: String,
	var title: String,
	var pageCount: Int,
	var summary: String
	)

@Entity(primaryKeys = ["bookId", "genreId"])
data class BookGenreLink(
	val bookId: Long,
	val genreId: Long
)