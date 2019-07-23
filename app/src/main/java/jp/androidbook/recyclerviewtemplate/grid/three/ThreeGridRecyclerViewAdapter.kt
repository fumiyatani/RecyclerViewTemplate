package jp.androidbook.recyclerviewtemplate.grid.three

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R
import kotlinx.android.synthetic.main.item_three_grid_recycler_view.view.*

class ThreeGridRecyclerViewAdapter(private val array: Array<String>, private val listener: OnTappedRecyclerViewListener)
    : RecyclerView.Adapter<ThreeGridRecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_three_grid_recycler_view,
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
        private val imageView = itemView.imageView2
        private val textView = itemView.textView3

        fun setText(text: String) {
            textView.text = text
        }
    }
}