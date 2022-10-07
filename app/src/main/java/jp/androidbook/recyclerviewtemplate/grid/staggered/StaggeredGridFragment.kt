package jp.androidbook.recyclerviewtemplate.grid.staggered

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import jp.androidbook.recyclerviewtemplate.OnTappedRecyclerViewListener
import jp.androidbook.recyclerviewtemplate.R

class StaggeredGridFragment : Fragment(), OnTappedRecyclerViewListener {

    private lateinit var staggeredRecyclerView: RecyclerView
    private lateinit var staggeredRecyclerAdapter: StaggeredRecyclerViewAdapter

    private lateinit var arrayList: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate: $CLASS_NAME")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: $CLASS_NAME")

        val itemView = inflater.inflate(R.layout.fragment_staggered_grid, container, false)

        val fab: FloatingActionButton = itemView.findViewById(R.id.fab)
        fab.setOnClickListener {
            addGrid()
        }

        arrayList = ArrayList(0)

        staggeredRecyclerAdapter = StaggeredRecyclerViewAdapter(arrayList, this)

        staggeredRecyclerView = itemView.findViewById(R.id.staggeredRecyclerView)
        staggeredRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
            adapter = staggeredRecyclerAdapter
        }

        return itemView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: $CLASS_NAME")
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

    private fun addGrid() {
        val element: String = when {
            arrayList.size % 2 == 0 -> {
                """${arrayList.size}
                    |medium 
                    |medium
                    |medium
                    """.trimMargin()
            }

            arrayList.size % 5 == 0 -> {
                """${arrayList.size}
                    |large
                    |large
                    |large
                    |large
                    |large
                    |large
                    |large
                    """.trimMargin()
            }

            else -> {
                """${arrayList.size}
                    |small small""".trimMargin()
            }
        }
        arrayList.add(arrayList.size, element)
        staggeredRecyclerAdapter.addItem(arrayList)
    }

    override fun onTapped(text: String) {
        Toast.makeText(context, "${text}をタップ", Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "DEBUGDEBUG"
        private const val CLASS_NAME = "StaggeredGridFragment"
    }
}
