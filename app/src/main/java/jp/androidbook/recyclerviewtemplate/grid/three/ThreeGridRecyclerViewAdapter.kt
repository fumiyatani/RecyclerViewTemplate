package jp.androidbook.recyclerviewtemplate.grid.three

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.databinding.ItemThreeGridRecyclerViewBinding

class ThreeGridRecyclerViewAdapter(
    private val array: Array<String>,
    private val listener: OnTappedRecyclerViewListener
) : RecyclerView.Adapter<ThreeGridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreeGridViewHolder {
        return ThreeGridViewHolder.createViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ThreeGridViewHolder, position: Int) {
        holder.setText(array[position])
        holder.itemView.setOnClickListener {
            listener.onTapped(array[position])
        }
    }
}

class ThreeGridViewHolder(
    private val binding: ItemThreeGridRecyclerViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setText(text: String) {
        binding.textView3.text = text
    }

    companion object {
        fun createViewHolder(parent: ViewGroup): ThreeGridViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemThreeGridRecyclerViewBinding.inflate(layoutInflater, parent, false)

            return ThreeGridViewHolder(binding)
        }
    }
}