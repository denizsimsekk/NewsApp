package com.denizsimsek.newseventsapp.service

import com.denizsimsek.newseventsapp.model.NewsList
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
//news api key->   ca0048511c6c4ae4a03e8caf11cb607d
//news api url->  https://newsapi.org/v2/top-headlines?country=tr&apiKey=ca0048511c6c4ae4a03e8caf11cb607d
class NewsAPIService {
    val BASE_URL="https://newsapi.org/v2/"
    val apiKey="apikey 1LzmJV9Uz1jwhpGXRmeItX:59or8MLv04BBL2Lnrs1Mor"
    val city="adana"
    val tag="general"
    val country="tr"
    val retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(NewsAPI::class.java)

    fun getData(): Single<NewsList>
    {
        return retrofit.getNews()
    }
}
