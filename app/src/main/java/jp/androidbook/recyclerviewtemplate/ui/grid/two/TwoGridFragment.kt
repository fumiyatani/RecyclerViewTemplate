package jp.androidbook.recyclerviewtemplate.ui.grid.two


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import jp.androidbook.recyclerviewtemplate.ui.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.databinding.FragmentTwoGridBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class TwoGridFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var binding: FragmentTwoGridBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoGridBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val items = Array(100) { i -> "テスト $i" }

        val gridLayoutManager = GridLayoutManager(this@TwoGridFragment.context, 2)
        val twoGridRecyclerViewAdapter = TwoGridRecyclerViewAdapter(items, this)

        binding.twoGridRecyclerView.apply {
            layoutManager = gridLayoutManager
            adapter = twoGridRecyclerViewAdapter
        }
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}をたっぷ", Toast.LENGTH_SHORT).show()
    }
}
