package com.denizsimsek.newseventsapp.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.denizsimsek.newseventsapp.R
import com.denizsimsek.newseventsapp.databinding.NewsRowBinding
import com.denizsimsek.newseventsapp.model.News

class NewsAdapter(var newsList:ArrayList<News>) :RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    class NewsHolder(val view: NewsRowBinding ) : RecyclerView.ViewHolder(view.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=DataBindingUtil.inflate<NewsRowBinding>(inflater,R.layout.news_row,parent,false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.view.news=newsList[position]
        holder.itemView.setOnClickListener{
            var url=holder.view.news!!.url
            val intentToBrowser=Intent(Intent.ACTION_VIEW)
            intentToBrowser.data=Uri.parse(url)
            holder.itemView.context.startActivity(intentToBrowser)
        }



    }


    override fun getItemCount(): Int {
       return newsList.size
    }

    fun refreshNewsList(newList:List<News>)
    {
        newsList.clear()
        newsList.addAll(newList)
        notifyDataSetChanged()
    }

}
