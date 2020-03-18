package jp.androidbook.recyclerviewtemplate.grid


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jp.androidbook.recyclerviewtemplate.R
import kotlinx.android.synthetic.main.fragment_grid_selection.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class GridSelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val itemView = inflater.inflate(R.layout.fragment_grid_selection, container, false)

        val gridSelectionViewPager = itemView.gridSelectionViewPager
        gridSelectionViewPager.adapter = GridSelectionViewPagerAdapter(parentFragmentManager)

        val gridSelectionTabLayout = itemView.gridSelectionTabLayout
        gridSelectionTabLayout.setupWithViewPager(gridSelectionViewPager)

        return itemView
    }

}
