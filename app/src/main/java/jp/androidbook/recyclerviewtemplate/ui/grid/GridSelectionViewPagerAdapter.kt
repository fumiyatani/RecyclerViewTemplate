package jp.androidbook.recyclerviewtemplate.ui.grid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import jp.androidbook.recyclerviewtemplate.ui.grid.three.ThreeGridFragment
import jp.androidbook.recyclerviewtemplate.ui.grid.two.TwoGridFragment

class GridSelectionViewPagerAdapter(
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (GridSelectionType.from(position)) {
            GridSelectionType.TWO_GRID ->
                TwoGridFragment()

            GridSelectionType.THREE_GRID ->
                ThreeGridFragment()
        }
    }

    override fun getCount(): Int {
        return GridSelectionType.values().size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return GridSelectionType.from(position).gridTitle
    }
}