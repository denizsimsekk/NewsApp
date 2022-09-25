package com.denizsimsek.newseventsapp.model

import com.google.gson.annotations.SerializedName

data class News (
    //@SerializedName("key")
    //var key:String,
    @SerializedName("url")
     var url:String,
    @SerializedName("description")
     var description:String,
  //  @SerializedName("image")
    //var image:String,
    @SerializedName("name")
     var name:String,
   //@SerializedName("source")
     //var source:String)
)
