package jp.androidbook.recyclerviewtemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import jp.androidbook.recyclerviewtemplate.drawer_menu.DrawerBodyItem
import jp.androidbook.recyclerviewtemplate.drawer_menu.DrawerHeaderItem
import jp.androidbook.recyclerviewtemplate.drawer_menu.DrawerListData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration

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
        navigationView = findViewById(R.id.navigationView)
        navigationView.setupWithNavController(navController)
        drawerLayout = findViewById(R.id.drawerLayout)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.simpleRecyclerFragment,
                R.id.gridSelectionFragment,
                R.id.staggeredGridFragment,
                R.id.updateFragment
            ),
            drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * Navigationのnavigateを機能をサポートする
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}
