package jp.androidbook.recyclerviewtemplate.ui.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import jp.androidbook.recyclerviewtemplate.databinding.FragmentSimpleRecyclerBinding

/**
 * SimpleなRecyclerViewのサンプル
 */
@AndroidEntryPoint
class SimpleRecyclerFragment : Fragment() {

    private lateinit var binding: FragmentSimpleRecyclerBinding

    private val simpleListViewModel: SimpleListViewModel by viewModels()

    private lateinit var simpleListAdapter: SimpleRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSimpleRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeLiveData()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        simpleListAdapter = SimpleRecyclerViewAdapter(viewModel = simpleListViewModel)

        binding.simpleRecyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = simpleListAdapter
        }
    }

    private fun observeLiveData() {
        simpleListViewModel.simpleTextList.observe(viewLifecycleOwner) {
            simpleListAdapter.submitList(it)
        }

        simpleListViewModel.selectEvent.observe(viewLifecycleOwner, "showToast") {
            Toast.makeText(context, "${it}をタップ", Toast.LENGTH_SHORT).show()
        }
    }
}
