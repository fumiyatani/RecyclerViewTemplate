package jp.androidbook.recyclerviewtemplate

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_drawer_header.*

class DrawerHeaderItem : Item() {
    override fun getLayout() = R.layout.item_drawer_header

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.drawerTopTextView.text = "これは上のテキスト"
        viewHolder.drawerBottomTextView.text = "これは下のテキスト"
    }
}