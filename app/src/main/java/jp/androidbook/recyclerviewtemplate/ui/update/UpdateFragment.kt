package jp.androidbook.recyclerviewtemplate.ui.update


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.ui.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.databinding.FragmentUpdateBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class UpdateFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var binding: FragmentUpdateBinding

    private lateinit var adapter: UpdateRecyclerViewAdapter

    private var arrayList: ArrayList<String> = ArrayList(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val updateRecyclerViewAdapter = UpdateRecyclerViewAdapter(arrayList, this)

        binding.updateRecyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = updateRecyclerViewAdapter
        }
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}をタップ", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_update_toolbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.plus -> {
                arrayList.add(arrayList.size, "テキスト ${arrayList.size}")
                adapter.addItem(arrayList)
                true
            }

            R.id.clear -> {
                if (arrayList.size - 1 < 0) {
                    return true
                }
                arrayList.removeAt(arrayList.size - 1)
                adapter.removeItem(arrayList)
                true
            }

            else -> {
                false
            }
        }
    }
}
