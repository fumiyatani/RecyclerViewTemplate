package jp.androidbook.recyclerviewtemplate.simple

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
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.databinding.FragmentSimpleRecyclerBinding

/**
 * SimpleなRecyclerViewのサンプル
 */
@AndroidEntryPoint
class SimpleRecyclerFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var binding: FragmentSimpleRecyclerBinding

    private val simpleListViewModel: SimpleListViewModel by viewModels()

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
    }

    private fun setupRecyclerView() {
        val items = Array(100) { "テスト $it" }

        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val simpleRecyclerViewAdapter = SimpleRecyclerViewAdapter(items, this)

        binding.simpleRecyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = simpleRecyclerViewAdapter
        }
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}をタップ", Toast.LENGTH_SHORT).show()
    }
}
