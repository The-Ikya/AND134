package com.technipixl.and134.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.technipixl.and134.model.dao.BookDao
import com.technipixl.and134.model.dao.BookGenreDao
import com.technipixl.and134.model.dao.GenreDao

@Database(entities = [Book::class, Genre::class, BookGenreLink::class], version = 1, exportSchema = true)
abstract class DataBase : RoomDatabase() {

	companion object {
		@Volatile
		private var sharedInstance: DataBase? = null

		fun getDB(context: Context) : DataBase {
			if (sharedInstance != null) return sharedInstance!!
			synchronized(this) {
				sharedInstance = Room
					.databaseBuilder(context, DataBase::class.java, "BookDatabase.db")
					.fallbackToDestructiveMigration()
					.build()
				return sharedInstance!!
			}
		}
	}

	abstract fun allDao() : BookGenreDao
	abstract fun bookDao() : BookDao
	abstract fun genreDao() : GenreDao
}