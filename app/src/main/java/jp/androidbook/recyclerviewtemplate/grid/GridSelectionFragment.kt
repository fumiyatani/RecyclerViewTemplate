package jp.androidbook.recyclerviewtemplate.grid


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import jp.androidbook.recyclerviewtemplate.R

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

        val gridSelectionViewPager: ViewPager = itemView.findViewById(R.id.gridSelectionViewPager)
        gridSelectionViewPager.adapter = GridSelectionViewPagerAdapter(parentFragmentManager)

        val gridSelectionTabLayout: TabLayout = itemView.findViewById(R.id.gridSelectionTabLayout)
        gridSelectionTabLayout.setupWithViewPager(gridSelectionViewPager)

        return itemView
    }

}
