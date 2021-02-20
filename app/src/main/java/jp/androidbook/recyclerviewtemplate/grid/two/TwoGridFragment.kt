package jp.androidbook.recyclerviewtemplate.grid.two


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R

/**
 * A simple [Fragment] subclass.
 *
 */
class TwoGridFragment : Fragment(), OnTappedRecyclerViewListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val itemView = inflater.inflate(R.layout.fragment_two_grid, container, false)

        val array = Array(100) {i -> "テスト $i" }

        val twoGridRecyclerView: RecyclerView = itemView.findViewById(R.id.twoGridRecyclerView)
        twoGridRecyclerView.apply {
            layoutManager = GridLayoutManager(this@TwoGridFragment.context, 2)
            adapter = TwoGridRecyclerViewAdapter(array, this@TwoGridFragment)
        }

        return itemView
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}をたっぷ", Toast.LENGTH_SHORT).show()
    }
}
