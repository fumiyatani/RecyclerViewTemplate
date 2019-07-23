package jp.androidbook.recyclerviewtemplate.update

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import kotlinx.android.synthetic.main.item_simple_recycler_view.view.*

class UpdateRecyclerViewAdapter(array: List<String>, private val listener: OnTappedRecyclerViewListener)
    : RecyclerView.Adapter<UpdateRecyclerViewAdapter.ViewHolder>() {

    // ここは公開する
    var array: List<String> = array
    set(array) {
        field = array
        notifyDataSetChanged()
    }

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

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.textView

        fun setText(text: String) {
            textView.text = text
        }
    }
}