package com.denizsimsek.newseventsapp.service


import com.denizsimsek.newseventsapp.model.NewsList
import io.reactivex.Single
import retrofit2.http.GET

interface NewsAPI {

    @GET("top-headlines?country=tr&apiKey=ca0048511c6c4ae4a03e8caf11cb607d")
    fun getNews(
        /*@Query("country") country: String,
        @Query("tag") tag: String,
        @Header("Authorization") apiKey:String*/
    ): Single<NewsList>


}
