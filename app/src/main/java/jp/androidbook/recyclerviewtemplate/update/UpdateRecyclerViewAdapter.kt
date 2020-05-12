package jp.androidbook.recyclerviewtemplate.update

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import kotlinx.android.synthetic.main.item_simple_recycler_view.view.*

class UpdateRecyclerViewAdapter(// ここは公開する
    private var array: List<String>, private val listener: OnTappedRecyclerViewListener)
    : RecyclerView.Adapter<UpdateRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_simple_recycler_view,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setText(array.get(position))
        holder.itemView.setOnClickListener {
            listener.onTapped(array.get(position))
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

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.textView

        fun setText(text: String) {
            textView.text = text
        }
    }
}