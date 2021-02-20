package jp.androidbook.recyclerviewtemplate.grid.two

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R

class TwoGridRecyclerViewAdapter(private val array: Array<String>, private val listener: OnTappedRecyclerViewListener)
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
            listener.onTapped(array[position])
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val textView: TextView = itemView.findViewById(R.id.textView2)

        fun setText(text: String) {
            textView.text = text
        }
    }
}