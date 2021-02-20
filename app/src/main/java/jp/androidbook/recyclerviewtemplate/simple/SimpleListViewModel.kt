package jp.androidbook.recyclerviewtemplate.simple

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.androidbook.recyclerviewtemplate.LiveEvent
import javax.inject.Inject

@HiltViewModel
class SimpleListViewModel @Inject constructor() : ViewModel() {

    private val _simpleTextList = MutableLiveData<List<SimpleText>>()
    val simpleTextList: LiveData<List<SimpleText>> = _simpleTextList

    val selectEvent: LiveEvent<String> = LiveEvent()

    init {
        val items = MutableList(100) {
            SimpleText("テスト$it")
        }
        _simpleTextList.value = items
    }

    fun onClickSimpleTextRow(simpleText: SimpleText) {
        selectEvent.call(simpleText.text)
    }
}