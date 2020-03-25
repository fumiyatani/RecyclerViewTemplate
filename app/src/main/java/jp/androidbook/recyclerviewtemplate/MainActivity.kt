package jp.androidbook.recyclerviewtemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
        setupDrawerRecyclerView()
        setupNavigation()
    }

    private fun setupDrawerRecyclerView() {
        val groupAdapter = GroupAdapter<GroupieViewHolder>()
        findViewById<RecyclerView>(R.id.drawerContentRecyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity).apply {
                orientation = RecyclerView.VERTICAL
            }
            addItemDecoration(DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL))
            adapter = groupAdapter
        }
        val items = mutableListOf<Item>(
            DrawerHeaderItem()
        )
        for (drawerText: String in DrawerListData.getDrawerBodyList()) {
            items.add(DrawerBodyItem(drawerText))
        }
        groupAdapter.update(items)
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.mainNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph) // todo Drawer を渡す
        findViewById<Toolbar>(R.id.toolBar).apply {
            setupActionBarWithNavController(navController, appBarConfiguration)
        }
    }
}
