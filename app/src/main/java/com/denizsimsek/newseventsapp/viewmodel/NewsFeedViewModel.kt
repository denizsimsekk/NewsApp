package com.denizsimsek.newseventsapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.denizsimsek.newseventsapp.model.News
import com.denizsimsek.newseventsapp.model.NewsList
import com.denizsimsek.newseventsapp.service.NewsAPIService
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class NewsFeedViewModel(application: Application) :BaseViewModel(application) {


    var newsList=MutableLiveData<NewsList>()
    var newsFeedError=MutableLiveData<Boolean>()
    var newsFeedLoading=MutableLiveData<Boolean>()

    private var compositeDisposable= CompositeDisposable()
    var apiService= NewsAPIService()
    var gson= GsonBuilder()
    lateinit var newList:ArrayList<News>

    public fun getNewsFromAPI() {
        compositeDisposable.add(apiService.getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<NewsList>()
            {
                override fun onSuccess(t: NewsList) {
                    showNews(t)
                }

                override fun onError(e: Throwable) {
                    newsFeedError.value=true
                    newsFeedLoading.value=false
                    Toast.makeText(getApplication(),e.localizedMessage,Toast.LENGTH_LONG).show()
                }

            }))
    }
    private fun showNews(t: NewsList)
    {
        newsList.value=t
        newsFeedError.value=false
        newsFeedLoading.value=false


        newsList.value=t

        /*t.newsList.forEach()
        {
           //println("name "+it.name)
            println("description"+it.description)
            println("description"+it.url)
        }*/
    }




}
