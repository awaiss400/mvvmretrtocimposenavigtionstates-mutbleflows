package com.stone.retromvvmgenerics

import com.stone.retromvvmgenerics.APi.ApiService
import com.stone.retromvvmgenerics.APi.Posts
import retrofit2.Response
import javax.inject.Inject

class Myrepository @Inject constructor(val apiService: ApiService) {
suspend fun getdata():List<Posts>{
   return apiService.GetPosts()
}
   suspend fun post(posts: Posts):Response<Posts>{
      return apiService.Postdata(posts)
   }
}