package jp.androidbook.recyclerviewtemplate.ui.simple

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.databinding.ItemSimpleRecyclerViewBinding

class SimpleListViewHolder(
    private val binding: ItemSimpleRecyclerViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(simpleText: SimpleText, viewModel: SimpleListViewModel) {
        binding.simpleText = simpleText
        binding.viewModel = viewModel
    }

    companion object {
        fun createViewHolder(parent: ViewGroup): SimpleListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemSimpleRecyclerViewBinding.inflate(layoutInflater, parent, false)

            return SimpleListViewHolder(binding)
        }
    }
}