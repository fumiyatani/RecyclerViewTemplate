package jp.androidbook.recyclerviewtemplate

object DrawerListData {
    fun getDrawerBodyList(): Array<DrawerBodyType> {
        return DrawerBodyType.values()
    }

    enum class DrawerBodyType(val id: Long, val drawerBodyText: String) {
        SimpleList(0, "SimpleList"),
        GridTwo(1, "SimpleList"),
        GridThree(2, "Grid-Three"),
        GridStaggered(3, "Grid-Staggered"),
        UpdatableList(4, "UpdatableList")
    }
}