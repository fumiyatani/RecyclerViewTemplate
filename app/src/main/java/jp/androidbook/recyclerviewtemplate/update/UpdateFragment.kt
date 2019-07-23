package jp.androidbook.recyclerviewtemplate.update


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.androidbook.recyclerviewtemplate.R
import jp.androidbook.recyclerviewtemplate.common.OnTappedRecyclerViewListener
import kotlinx.android.synthetic.main.fragment_update.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class UpdateFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var adapter: UpdateRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val itemView = inflater.inflate(R.layout.fragment_update, container, false)

        val array = mutableListOf<String>()

        adapter = UpdateRecyclerViewAdapter(array, this@UpdateFragment)

        val updateRecyclerView = itemView.updateRecyclerView
        updateRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@UpdateFragment.context, RecyclerView.VERTICAL, false)
            adapter = this@UpdateFragment.adapter
        }

        return itemView
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}をタップ", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_update_toolbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.plus -> {
                adapter.plusRecyclerView()
                true
            }

            R.id.clear -> {
                adapter.clearRecyclerView()
                true
            }

            else -> {
                false
            }
        }
    }
}
