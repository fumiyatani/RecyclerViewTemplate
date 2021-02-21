package jp.androidbook.recyclerviewtemplate.ui.grid.two

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.ui.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.databinding.ItemTwoGridRecyclerViewBinding

class TwoGridRecyclerViewAdapter(
    private val array: Array<String>,
    private val listener: OnTappedRecyclerViewListener
) : RecyclerView.Adapter<TwoGridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoGridViewHolder {
        return TwoGridViewHolder.createViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: TwoGridViewHolder, position: Int) {
        holder.setText(array[position])
        holder.itemView.setOnClickListener {
            listener.onTapped(array[position])
        }
    }
}

class TwoGridViewHolder(
    private val binding: ItemTwoGridRecyclerViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setText(text: String) {
        binding.textView2.text = text
    }

    companion object {
        fun createViewHolder(parent: ViewGroup): TwoGridViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemTwoGridRecyclerViewBinding.inflate(layoutInflater, parent, false)

            return TwoGridViewHolder(binding)
        }
    }
}