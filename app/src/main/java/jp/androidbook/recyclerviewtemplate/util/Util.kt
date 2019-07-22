package jp.androidbook.recyclerviewtemplate.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun <T: Fragment>fragmentReplace(fragmentManger: FragmentManager, resId: Int, fragment: T) {
    fragmentManger.beginTransaction().apply {
        replace(resId, fragment)
    }.commit()
}