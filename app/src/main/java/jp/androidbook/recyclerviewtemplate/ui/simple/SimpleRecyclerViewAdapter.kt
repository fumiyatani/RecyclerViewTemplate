package jp.androidbook.recyclerviewtemplate.ui.simple

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter

class SimpleRecyclerViewAdapter(
    diffUtil: ItemCallback<SimpleText> = getSimpleTextDiffUtil(),
    private val viewModel: SimpleListViewModel
) : ListAdapter<SimpleText, SimpleListViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListViewHolder {
        return SimpleListViewHolder.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: SimpleListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, viewModel)
    }

    companion object {
        private fun getSimpleTextDiffUtil() = object : ItemCallback<SimpleText>() {

            override fun areContentsTheSame(oldItem: SimpleText, newItem: SimpleText): Boolean {
                return oldItem.text == newItem.text
            }

            override fun areItemsTheSame(oldItem: SimpleText, newItem: SimpleText): Boolean {
                return oldItem == newItem
            }
        }
    }
}