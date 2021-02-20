package jp.androidbook.recyclerviewtemplate.simple

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener

class SimpleRecyclerViewAdapter(
    private val arrayList: Array<String>,
    private val listener: OnTappedRecyclerViewListener
) : RecyclerView.Adapter<SimpleListViewHolder>() {

    // ViewHolderを生成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListViewHolder {
        return SimpleListViewHolder.createViewHolder(parent)
    }

    // RecyclerViewで表示するリストの数を返す
    override fun getItemCount(): Int {
        return arrayList.size
    }

    // ViewHolderのViewと値を繋げる
    override fun onBindViewHolder(holder: SimpleListViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onTapped(arrayList[position])
        }

        holder.bind(arrayList[position])
    }
}