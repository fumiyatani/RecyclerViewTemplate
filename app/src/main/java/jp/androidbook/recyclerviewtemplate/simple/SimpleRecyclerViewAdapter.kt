package jp.androidbook.recyclerviewtemplate.simple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R
import kotlinx.android.synthetic.main.item_simple_recycler_view.view.*

class SimpleRecyclerViewAdapter(
        private val arrayList: Array<String>,
        private val listener: OnTappedRecyclerViewListener
)
    : RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder>() {

    interface SimpleRecyclerViewTappedListener {
        fun onTapped(text: String)
    }

    // ViewHolderを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_simple_recycler_view,
                parent,
                false
        )
        return ViewHolder(
            itemView
        )
    }

    // RecyclerViewで表示するリストの数を返す
    override fun getItemCount(): Int {
        return arrayList.size
    }

    // ViewHolderのViewと値を繋げる
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