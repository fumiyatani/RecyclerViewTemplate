package jp.androidbook.recyclerviewtemplate.update


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.databinding.FragmentUpdateBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class UpdateFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var binding: FragmentUpdateBinding

    private lateinit var adapter: UpdateRecyclerViewAdapter

    private lateinit var arrayList: MutableList<String>

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
        arrayList = mutableListOf()
        adapter = UpdateRecyclerViewAdapter( arrayList, this)
        binding.updateRecyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = this@UpdateFragment.adapter
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
                addItem()
                true
            }

            R.id.clear -> {
                removeItem()
                true
            }

            else -> {
                false
            }
        }
    }

    private fun addItem() {
        arrayList.add("テキスト ${arrayList.size}")
        adapter.addItem(arrayList)
    }

    private fun removeItem() {
        // 配列内が空の場合は処理をさせる必要がないので return させる
        if (arrayList.size - 1 < 0) {
            return
        }
        arrayList.removeAt(arrayList.size - 1)
        adapter.removeItem(arrayList)
    }
}
