package com.technipixl.and134

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technipixl.and134.databinding.FragmentBookListBinding
import com.technipixl.and134.model.BookViewModel

class BookListFragment : Fragment() {

	private var _binding: FragmentBookListBinding? = null
	private val binding get() = _binding!!

	private val viewModel: BookViewModel by activityViewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentBookListBinding.inflate(inflater, container, false)

		binding.lifecycleOwner = viewLifecycleOwner
		binding.viewModel = viewModel
		binding.recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
		binding.recyclerView.adapter = BookListView()
//		viewModel.getAllBooks().observe(viewLifecycleOwner) {
//			(binding.recyclerView.adapter as BookListView).submitList(it)
//		}


		return binding.root
	}
}