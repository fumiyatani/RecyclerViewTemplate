package jp.androidbook.recyclerviewtemplate.grid.three


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
class ThreeGridFragment : Fragment(), OnTappedRecyclerViewListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val itemView = inflater.inflate(R.layout.fragment_three_grid, container, false)

        val array = Array(100) {i -> "テスト $i" }

        val threeGridRecyclerView: RecyclerView = itemView.findViewById(R.id.threeGridRecyclerView)
        threeGridRecyclerView.apply {
            layoutManager = GridLayoutManager(this@ThreeGridFragment.context, 3)
            adapter = ThreeGridRecyclerViewAdapter(array, this@ThreeGridFragment)
        }
        return itemView
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}です。", Toast.LENGTH_SHORT).show()
    }
}
