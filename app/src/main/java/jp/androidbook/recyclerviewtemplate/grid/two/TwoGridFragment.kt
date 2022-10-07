package jp.androidbook.recyclerviewtemplate.grid.two


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.databinding.FragmentTwoGridBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class TwoGridFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var binding: FragmentTwoGridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: $CLASS_NAME")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: $CLASS_NAME")

        binding = FragmentTwoGridBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: $CLASS_NAME")

        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "★★onResume★★: $CLASS_NAME")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "★★onPause★★: $CLASS_NAME")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop: $CLASS_NAME")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: $CLASS_NAME")
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

    companion object {
        private const val TAG = "DEBUGDEBUG"
        private const val CLASS_NAME = "TwoGridFragment"
    }
}
