package com.stone.retromvvmgenerics.APi

import com.stone.retromvvmgenerics.APi.Posts
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    companion object{
        const val BASE_URL="https://jsonplaceholder.typicode.com/"
    }
    @GET("posts")
    suspend fun GetPosts():List<Posts>
@GET("/posts/1/comments")
    suspend fun GetPoststwo():List<Posts>

    @POST("/posts")
    suspend fun Postdata(@Body post: Posts):List<Posts>
    }