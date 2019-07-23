package jp.androidbook.recyclerviewtemplate.update

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.common.OnTappedRecyclerViewListener
import kotlinx.android.synthetic.main.item_simple_recycler_view.view.*

class UpdateRecyclerViewAdapter(private val array: MutableList<String>?, private val listener: OnTappedRecyclerViewListener)
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
        return array?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setText(array?.get(position) ?: "")
        holder.itemView.setOnClickListener {
            listener.onTapped(array?.get(position) ?: "")
        }
    }

    fun plusRecyclerView() {
        array?.add(array.size, "テキスト ${array.size}")
        notifyDataSetChanged()
    }

    fun clearRecyclerView() {
        if (array.isNullOrEmpty()) {
            return
        }
        array.removeAt(array.size - 1)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.textView

        fun setText(text: String) {
            textView.text = text
        }
    }
}