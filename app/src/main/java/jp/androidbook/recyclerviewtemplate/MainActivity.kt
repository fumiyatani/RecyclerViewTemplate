package jp.androidbook.recyclerviewtemplate

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SimpleRecyclerViewAdapter.SimpleRecyclerViewTappedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = Array(100) {"テスト $it"}

        simpleRecyclerView.apply {
            layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    RecyclerView.VERTICAL,
                    false)
            adapter = SimpleRecyclerViewAdapter(array, this@MainActivity)
        }
    }

    override fun onTapped(text: String) {
        Toast.makeText(this, "${text}をタップ", Toast.LENGTH_SHORT).show()
    }
}
