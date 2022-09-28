package com.denizsimsek.newseventsapp.model

import com.google.gson.annotations.SerializedName

data class News (
    //var source:NewsSource,
    var key:String,
    var url:String,
    var description:String,
    var image:String,
    var name:String,
    var source:String


)
