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

        if (savedInstanceState === null) {
            fragmentReplace(supportFragmentManager, R.id.fragmentContainer, SimpleRecyclerFragment())
        }

        // Selected したら true を返すようにする
        bottomNavigation.setOnNavigationItemSelectedListener {
            transitionFragment(it.itemId)
        }
    }

    private fun transitionFragment(itemId: Int): Boolean = when(itemId) {
        R.id.navigation_simple -> {
            fragmentReplace(supportFragmentManager, R.id.fragmentContainer, SimpleRecyclerFragment())
            true
        }

        R.id.navigation_grid -> {
            fragmentReplace(supportFragmentManager, R.id.fragmentContainer, GridSelectionFragment())
            true
        }

        R.id.navigation_stagger_grid -> {
            fragmentReplace(supportFragmentManager, R.id.fragmentContainer, StaggerdGridFragment())
            true
        }

        R.id.navigation_update -> {
            fragmentReplace(supportFragmentManager, R.id.fragmentContainer, UpdateFragment())
            true
        }

        else -> {
            false
        }
    }
}
