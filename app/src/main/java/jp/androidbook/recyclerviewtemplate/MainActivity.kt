package jp.androidbook.recyclerviewtemplate

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
        setupDrawerRecyclerView()
        setupNavigation()
    }

    private fun setupDrawerRecyclerView() {
        val groupAdapter = GroupAdapter<GroupieViewHolder>().apply {
            setOnItemClickListener { item, _ ->
                when (item.id) {
                    DrawerListData.DrawerBodyType.SimpleList.id -> {
                        navController.navigate(R.id.simpleRecyclerFragment)
                    }
                    DrawerListData.DrawerBodyType.GridTwo.id -> {
                        navController.navigate(R.id.gridSelectionFragment)
                    }
                    DrawerListData.DrawerBodyType.GridThree.id -> {
                        navController.navigate(R.id.gridSelectionFragment)
                    }
                    DrawerListData.DrawerBodyType.GridStaggered.id -> {
                        navController.navigate(R.id.staggeredGridFragment)
                    }
                    DrawerListData.DrawerBodyType.UpdatableList.id -> {
                        navController.navigate(R.id.updateFragment)
                    }
                }
            }
        }
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
        for (drawerBodyType: DrawerListData.DrawerBodyType in DrawerListData.getDrawerBodyList()) {
            items.add(DrawerBodyItem(drawerBodyType.id, drawerBodyType.drawerBodyText))
        }
        groupAdapter.update(items)
    }

    private fun setupNavigation() {
        navController = findNavController(R.id.mainNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph) // todo Drawer を渡す
        findViewById<Toolbar>(R.id.toolBar).apply {
            setupActionBarWithNavController(navController, appBarConfiguration)
        }
    }
}
