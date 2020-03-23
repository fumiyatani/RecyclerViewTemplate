package jp.androidbook.recyclerviewtemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jp.androidbook.recyclerviewtemplate.grid.GridSelectionFragment
import jp.androidbook.recyclerviewtemplate.simple.SimpleRecyclerFragment
import jp.androidbook.recyclerviewtemplate.staggerd.StaggerdGridFragment
import jp.androidbook.recyclerviewtemplate.update.UpdateFragment
import jp.androidbook.recyclerviewtemplate.util.fragmentReplace
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
    }
}
