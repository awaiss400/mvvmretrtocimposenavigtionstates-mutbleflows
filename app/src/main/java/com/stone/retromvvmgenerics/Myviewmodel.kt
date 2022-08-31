package com.stone.retromvvmgenerics

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stone.retromvvmgenerics.APi.Posts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.POST
import javax.inject.Inject

@HiltViewModel
class Myviewmodel @Inject constructor(val myrepository: Myrepository):ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading
    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError
    val _words = MutableStateFlow(mutableListOf<Posts>())
    val mydata=_words.value

    val posts: StateFlow<List<Posts>> = _words
//    val _response = MutableStateFlow(emptyList<Response<Posts>>())
//    val response: MutableStateFlow<List<Response<Posts>>> = _response
    init {
    load()
}

    fun load() = viewModelScope.launch(Dispatchers.IO) {
        _isLoading.value = true
        try {
        _words.value = myrepository.getdata().toMutableList()
        }catch (e:Throwable){
            _isError.value=true
        }
        _isLoading.value = false
    }
    fun post(posts: Posts)=viewModelScope.launch {
       val resopnse =myrepository.post(posts)
        mydata.add(resopnse.body()!!)
        _words.value=mydata
//        _words.value=resopnse

    }


}