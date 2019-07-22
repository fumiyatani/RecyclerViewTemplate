package jp.androidbook.recyclerviewtemplate.grid.three


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jp.androidbook.recyclerviewtemplate.R

/**
 * A simple [Fragment] subclass.
 *
 */
class ThreeGridFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three_grid, container, false)
    }


}
