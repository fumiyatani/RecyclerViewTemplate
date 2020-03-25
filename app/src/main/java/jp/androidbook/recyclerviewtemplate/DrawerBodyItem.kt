package jp.androidbook.recyclerviewtemplate

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_drawer_body.*

class DrawerBodyItem(private val drawerText: String) : Item() {
    override fun getLayout() = R.layout.item_drawer_body

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder) {
            drawerTextView.text = drawerText
        }
    }
}