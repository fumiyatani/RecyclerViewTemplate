package jp.androidbook.recyclerviewtemplate.ui.update

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.databinding.ItemSimpleRecyclerViewBinding

class UpdateViewHolder(
    binding: ItemSimpleRecyclerViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    private val textView: TextView = itemView.findViewById(R.id.textView)

    fun setText(text: String) {
        textView.text = text
    }

    companion object {
        fun createViewHolder(parent: ViewGroup): UpdateViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemSimpleRecyclerViewBinding.inflate(layoutInflater, parent, false)

            return UpdateViewHolder(binding)
        }
    }
}