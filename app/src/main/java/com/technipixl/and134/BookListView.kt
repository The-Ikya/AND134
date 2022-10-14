package com.technipixl.and134

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.and134.databinding.BookCellBinding
import com.technipixl.and134.model.Book

class BookListView : ListAdapter<Book, BookListView.BookListViewHolder>(DiffCallBack) {

	companion object DiffCallBack : ItemCallback<Book>() {
		override fun areItemsTheSame(oldItem: Book, newItem: Book) =
			oldItem.bookId == newItem.bookId

		override fun areContentsTheSame(oldItem: Book, newItem: Book) =
			oldItem.title == newItem.title
	}

	class BookListViewHolder(private val binding: BookCellBinding)
		: RecyclerView.ViewHolder(binding.root) {
		fun binds(book: Book) {
			binding.book = book
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		BookListViewHolder(BookCellBinding.inflate(LayoutInflater.from(parent.context), parent, false))

	override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
		holder.binds(getItem(position))
	}
}