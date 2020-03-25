package jp.androidbook.recyclerviewtemplate.staggered

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R
import kotlinx.android.synthetic.main.fragment_staggerd_grid.view.*

class StaggeredGridFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var staggerdRecyclerView: RecyclerView
    private lateinit var staggerdRecyclerAdapter: StaggeredRecyclerViewAdapter

    private lateinit var arrayList: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = inflater.inflate(R.layout.fragment_staggerd_grid, container, false)

        val fab = itemView.fab
        fab.setOnClickListener {
            onClickFAB()
        }

        arrayList = ArrayList(0)

        staggerdRecyclerAdapter = StaggeredRecyclerViewAdapter(arrayList, this)

        staggerdRecyclerView = itemView.staggerdRecyclerView
        staggerdRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
            adapter = staggerdRecyclerAdapter
        }

        return itemView
    }

    private fun onClickFAB() {
        val element: String = when {
            arrayList.size % 2 == 0 -> {
                "これは2で割り切れます。"
            }

            arrayList.size % 4 == 0 -> {
                "これは4で割り切れるので相当長い文章を入れようと思っています。"
            }

            arrayList.size % 5 == 0 -> {
                """これは5で割り切れます。
                        |なので改行をありしようと思います。
                        |どんどん長くなります。
                    """.trimMargin()
            }

            else -> {
                "テスト ${arrayList.size}"
            }
        }
        arrayList.add(arrayList.size, element)
        staggerdRecyclerAdapter.arrayList = arrayList
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}をタップ", Toast.LENGTH_SHORT).show()
    }
}
