package jp.androidbook.recyclerviewtemplate.grid

enum class GridSelectionType(private val position: Int, val gridTitle: String) {
    TWO_GRID(0, "2Grid"),
    THREE_GRID(1, "3Grid"),
    STAGGERED_GRID(2, "Staggered");

    companion object {
        fun from(position: Int): GridSelectionType {
            for (type in values()) {
                if (type.position == position) return type
            }

            throw IllegalArgumentException("存在しない値です。")
        }
    }
}