package jp.androidbook.recyclerviewtemplate.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.R
import kotlinx.android.synthetic.main.fragment_simple_recycler.view.*

/**
 * SimpleなRecyclerViewのサンプル
 */
class SimpleRecyclerFragment : Fragment(),
    SimpleRecyclerViewAdapter.SimpleRecyclerViewTappedListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_simple_recycler, container, false)

        val array = Array(100) {"テスト $it"}

        val simpleRecyclerView = itemView.simpleRecyclerView
        simpleRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@SimpleRecyclerFragment.context, RecyclerView.VERTICAL, false)
            adapter = SimpleRecyclerViewAdapter(
                array,
                this@SimpleRecyclerFragment
            )
        }
        return itemView
    }


    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}をタップ", Toast.LENGTH_SHORT).show()
    }
}
