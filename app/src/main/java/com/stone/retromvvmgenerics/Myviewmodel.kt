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
import retrofit2.http.POST
import javax.inject.Inject

@HiltViewModel
class Myviewmodel @Inject constructor(val myrepository: Myrepository):ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading
    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError
    val _words = MutableStateFlow(emptyList<Posts>())
    val posts: StateFlow<List<Posts>> = _words
    val _wordspost = MutableStateFlow(emptyList<Posts>())
    val postsdata: StateFlow<List<Posts>> = _words
init {
    load()
}

    fun load() = viewModelScope.launch(Dispatchers.IO) {
        _isLoading.value = true
        try {
        _words.value = myrepository.getdata()
        }catch (e:Throwable){
            _isError.value=true
        }
        _isLoading.value = false
    }
    fun post(posts: Posts)=viewModelScope.launch {
        _wordspost.value=myrepository.post(posts)

    }


}