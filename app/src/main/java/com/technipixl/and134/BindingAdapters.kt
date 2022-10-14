package com.technipixl.and134

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.and134.model.Book

@BindingAdapter("listData")
fun bindBookRecyclerView(recyclerView: RecyclerView, data: List<Book>?) {
	val adapter = recyclerView.adapter as BookListView
	adapter.submitList(data)
}

@BindingAdapter("pageCount")
fun bindPageCount(textView: TextView, count: Int) {
	textView.text = textView.context.getString(R.string.nbPages, count)
}