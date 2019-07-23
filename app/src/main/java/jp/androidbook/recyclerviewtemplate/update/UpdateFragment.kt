package jp.androidbook.recyclerviewtemplate.update


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import jp.androidbook.recyclerviewtemplate.R

/**
 * A simple [Fragment] subclass.
 *
 */
class UpdateFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_update, container, false)


        return itemView
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_update_toolbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.plus -> {
                println("プラスボタンタップ")
                true
            }

            R.id.clear -> {
                println("マイナスボタンタップ")
                true
            }

            else -> {
                false
            }
        }
    }
}
