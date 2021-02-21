package jp.androidbook.recyclerviewtemplate.ui.update

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.ui.OnTappedRecyclerViewListener

class UpdateRecyclerViewAdapter(
    private var array: List<String>,
    private val listener: OnTappedRecyclerViewListener
) : RecyclerView.Adapter<UpdateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdateViewHolder {
        return UpdateViewHolder.createViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: UpdateViewHolder, position: Int) {
        holder.setText(array[position])
        holder.itemView.setOnClickListener {
            listener.onTapped(array[position])
        }
    }

    fun addItem(array: List<String>) {
        this.array = array
        val currentPosition = array.count()
        notifyItemInserted(currentPosition)
    }

    fun removeItem(array: List<String>) {
        val currentPosition = array.count()
        this.array = array
        notifyItemRemoved(currentPosition)
    }
}