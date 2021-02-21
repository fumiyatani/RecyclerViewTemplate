package jp.androidbook.recyclerviewtemplate.ui.grid.three


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import jp.androidbook.recyclerviewtemplate.ui.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.databinding.FragmentThreeGridBinding

/**
 * A simple [Fragment] subclass.
 */
class ThreeGridFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var binding: FragmentThreeGridBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThreeGridBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val items = Array(100) { i -> "テスト $i" }

        val gridLayoutManager = GridLayoutManager(context, 3)
        val threeGridRecyclerViewAdapter = ThreeGridRecyclerViewAdapter(items, this)

        binding.threeGridRecyclerView.apply {
            layoutManager = gridLayoutManager
            adapter = threeGridRecyclerViewAdapter
        }
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}です。", Toast.LENGTH_SHORT).show()
    }
}
