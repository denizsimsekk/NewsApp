package com.denizsimsek.newseventsapp.model

import com.denizsimsek.newseventsapp.model.News
import com.google.gson.annotations.SerializedName

data class NewsList(@SerializedName("result")
               var newsList:List<News>)
