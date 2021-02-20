package jp.androidbook.recyclerviewtemplate.simple

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.databinding.ItemSimpleRecyclerViewBinding

class SimpleRecyclerViewAdapter(
    private val arrayList: Array<String>,
    private val listener: OnTappedRecyclerViewListener
) : RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder>() {

    // ViewHolderを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.createViewHolder(parent)
    }

    // RecyclerViewで表示するリストの数を返す
    override fun getItemCount(): Int {
        return arrayList.size
    }

    // ViewHolderのViewと値を繋げる
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setText(arrayList[position])
        holder.itemView.setOnClickListener {
            listener.onTapped(arrayList[position])
        }
    }

    class ViewHolder(
        private val binding: ItemSimpleRecyclerViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setText(text: String) {
            binding.textView.text = text
        }

        companion object {
            fun createViewHolder(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSimpleRecyclerViewBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}