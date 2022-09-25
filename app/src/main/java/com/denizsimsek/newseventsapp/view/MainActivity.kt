package com.denizsimsek.newseventsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denizsimsek.newseventsapp.service.NewsAPIService
import com.denizsimsek.newseventsapp.model.News
import com.denizsimsek.newseventsapp.model.NewsList
import com.denizsimsek.newseventsapp.R
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }



}




