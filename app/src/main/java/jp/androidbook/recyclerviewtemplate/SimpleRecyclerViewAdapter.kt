package jp.androidbook.recyclerviewtemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_simple_recycler_view.view.*

class SimpleRecyclerViewAdapter(private val arrayList: Array<String>, private val listener: SimpleRecyclerViewTappedListener): RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder>() {

    interface SimpleRecyclerViewTappedListener {
        fun onTapped(text: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_simple_recycler_view,
                parent,
                false
        )
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setText(arrayList[position])
        holder.itemView.setOnClickListener {
            listener.onTapped(arrayList[position])
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.textView

        fun setText(text: String) {
            textView.text = text
        }
    }
}