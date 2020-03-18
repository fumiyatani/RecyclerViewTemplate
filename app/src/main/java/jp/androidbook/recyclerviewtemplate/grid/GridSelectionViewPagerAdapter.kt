package jp.androidbook.recyclerviewtemplate.grid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import jp.androidbook.recyclerviewtemplate.grid.three.ThreeGridFragment
import jp.androidbook.recyclerviewtemplate.grid.two.TwoGridFragment

class GridSelectionViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                TwoGridFragment()
            }

            1 -> {
                ThreeGridFragment()
            }

            else -> {
                Fragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> {
                "2Grid"
            }

            1 -> {
                "3Grid"
            }

            else -> {
                ""
            }
        }
    }
}