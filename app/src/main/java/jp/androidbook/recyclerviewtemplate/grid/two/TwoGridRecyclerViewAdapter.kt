package jp.androidbook.recyclerviewtemplate.grid.two

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.grid.GridTappedListener
import kotlinx.android.synthetic.main.item_two_grid_recycler_view.view.*

class TwoGridRecyclerViewAdapter(private val array: Array<String>, private val listener: GridTappedListener)
    : RecyclerView.Adapter<TwoGridRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_two_grid_recycler_view,
            parent,
            false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setText(array[position])
        holder.itemView.setOnClickListener {
            listener.onTappedGrid(array[position])
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.imageView
        private val textView = itemView.textView2

        fun setText(text: String) {
            textView.text = text
        }
    }
}