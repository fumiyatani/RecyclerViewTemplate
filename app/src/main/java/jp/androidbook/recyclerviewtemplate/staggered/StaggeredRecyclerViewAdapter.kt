package jp.androidbook.recyclerviewtemplate.staggered

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R
import kotlinx.android.synthetic.main.item_staggered_recycler_view.view.*

class StaggeredRecyclerViewAdapter(
    arrayList: List<String>,
    private val listener: OnTappedRecyclerViewListener)
    : RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder>() {

    var arrayList = arrayList
    set(arrayList) {
        field = arrayList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_staggered_recycler_view,
            parent,
            false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onTapped(arrayList[position])
        }
        holder.textView.text = arrayList[position]
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.staggerdImageView
        val textView: TextView = itemView.staggerdTextView
    }
}