package jp.androidbook.recyclerviewtemplate.animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import jp.androidbook.recyclerviewtemplate.R

/**
 * A simple [Fragment] subclass.
 */
class AnimationListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation_list, container, false)
    }

}
