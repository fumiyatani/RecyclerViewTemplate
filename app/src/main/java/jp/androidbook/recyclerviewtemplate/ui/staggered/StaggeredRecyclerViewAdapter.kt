package jp.androidbook.recyclerviewtemplate.ui.staggered

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.ui.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.databinding.ItemStaggeredRecyclerViewBinding

class StaggeredRecyclerViewAdapter(
    private var arrayList: List<String>,
    private val listener: OnTappedRecyclerViewListener
) : RecyclerView.Adapter<StaggeredGridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaggeredGridViewHolder {
        return StaggeredGridViewHolder.createViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: StaggeredGridViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onTapped(arrayList[position])
        }
        holder.bind(arrayList[position])
    }

    fun addItem(array: List<String>) {
        arrayList = array
        val currentPosition = array.count()
        notifyItemInserted(currentPosition)
    }
}

class StaggeredGridViewHolder(
    private val binding: ItemStaggeredRecyclerViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(text: String) {
        binding.staggeredTextView.text = text
    }

    companion object {
        fun createViewHolder(parent: ViewGroup): StaggeredGridViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemStaggeredRecyclerViewBinding.inflate(layoutInflater, parent, false)

            return StaggeredGridViewHolder(binding)
        }
    }
}