package com.technipixl.and134.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Genre(
	@PrimaryKey(autoGenerate = true)
	val genreId: Long = 0,
	val name: String
)
