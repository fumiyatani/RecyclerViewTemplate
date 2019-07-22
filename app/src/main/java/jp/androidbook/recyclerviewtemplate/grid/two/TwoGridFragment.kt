package jp.androidbook.recyclerviewtemplate.grid.two


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.grid.GridTappedListener
import kotlinx.android.synthetic.main.fragment_two_grid.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class TwoGridFragment : Fragment(), GridTappedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val itemView = inflater.inflate(R.layout.fragment_two_grid, container, false)

        val array = Array(100) {i -> "テスト $i" }

        val twoGridRecyclerView = itemView.twoGridRecyclerView
        twoGridRecyclerView.apply {
            layoutManager = GridLayoutManager(this@TwoGridFragment.context, 2)
            adapter = TwoGridRecyclerViewAdapter(array, this@TwoGridFragment)
        }

        return itemView
    }

    override fun onTappedGrid(text: String) {
        Toast.makeText(context, "${text}をたっぷ", Toast.LENGTH_SHORT).show()
    }
}
