package jp.androidbook.recyclerviewtemplate.ui.grid


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import jp.androidbook.recyclerviewtemplate.databinding.FragmentGridSelectionBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class GridSelectionFragment : Fragment() {

    private lateinit var binding: FragmentGridSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGridSelectionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTabLayout()
    }

    private fun setupTabLayout() {
        // setup ViewPager
        val gridSelectionViewPager: ViewPager = binding.gridSelectionViewPager.apply {
            adapter = GridSelectionViewPagerAdapter(parentFragmentManager)
        }

        // setup TabLayout
        binding.gridSelectionTabLayout.apply {
            setupWithViewPager(gridSelectionViewPager)
        }
    }
}
