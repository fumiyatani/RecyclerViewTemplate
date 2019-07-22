package jp.androidbook.recyclerviewtemplate.grid.three


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.grid.GridTappedListener
import kotlinx.android.synthetic.main.fragment_three_grid.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ThreeGridFragment : Fragment(), GridTappedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val itemView = inflater.inflate(R.layout.fragment_three_grid, container, false)

        val array = Array(100) {i -> "テスト $i" }

        val threeGridRecyclerView = itemView.threeGridRecyclerView
        threeGridRecyclerView.apply {
            layoutManager = GridLayoutManager(this@ThreeGridFragment.context, 3)
            adapter = ThreeGridRecyclerViewAdapter(array, this@ThreeGridFragment)
        }
        return itemView
    }

    override fun onTappedGrid(text: String) {
        Toast.makeText(context, "${text}です。", Toast.LENGTH_SHORT).show()
    }
}
