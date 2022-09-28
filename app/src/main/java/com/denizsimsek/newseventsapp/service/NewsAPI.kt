package com.denizsimsek.newseventsapp.service


import com.denizsimsek.newseventsapp.model.NewsList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsAPI {

   // @GET("top-headlines?country=tr&apiKey=ca0048511c6c4ae4a03e8caf11cb607d") ->newsapi
    @GET("news/getNews?country=tr&tag=general")
    fun getNews(
        /*@Query("country") country: String,
        @Query("tag") tag: String,
        @Header("Authorization") apiKey:String*/
       @Query("content-type") type: String,
       @Header("Authorization") apiKey:String
    ): Single<NewsList>


}
