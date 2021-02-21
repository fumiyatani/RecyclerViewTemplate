package jp.androidbook.recyclerviewtemplate.ui

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

open class LiveEvent<T> : LiveData<T>() {

    private val dispatchedTagSet = mutableSetOf<String>()

    /**
     * @deprecated use observe(LifecycleOwner, String, Observer<in T>), instead of observe(LifecycleOwner, Observer<in T>)
     */
    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        observe(owner, "", observer)
    }

    /**
     * @deprecated use observeForever(String, Observer<in T>), instead of observe(Observer<in T>)
     */
    @MainThread
    override fun observeForever(observer: Observer<in T>) {
        observeForever("", observer)
    }

    @MainThread
    open fun observe(owner: LifecycleOwner, eventTag: String, observer: Observer<in T>) {
        super.observe(owner, {
            val internalTag = "${owner::class.java.name}#$eventTag"

            if (internalTag !in dispatchedTagSet) {
                dispatchedTagSet.add(internalTag)
                observer.onChanged(it)
            }
        })
    }

    @MainThread
    open fun observeForever(eventTag: String, observer: Observer<in T>) {
        super.observeForever {
            if (eventTag !in dispatchedTagSet) {
                dispatchedTagSet.add(eventTag)
                observer.onChanged(it)
            }
        }
    }

    @MainThread
    open fun call(t: T?) {
        dispatchedTagSet.clear()
        value = t
    }
}