package com.denizsimsek.newseventsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.denizsimsek.newseventsapp.service.NewsAPIService
import com.denizsimsek.newseventsapp.model.News
import com.denizsimsek.newseventsapp.model.NewsList
import com.denizsimsek.newseventsapp.R
import com.denizsimsek.newseventsapp.adapter.ViewPagerAdapter
import com.denizsimsek.newseventsapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var labels = arrayListOf<String>("Haberler","Etkinlikler")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        val viewPager=binding.viewPager
        val fragments:ArrayList<Fragment> = arrayListOf(NewsFeedFragment(),EventsFragment())

        val adapter= ViewPagerAdapter(fragments,this)
        viewPager.adapter=adapter

        val tabLayout=binding.tabLayout
        TabLayoutMediator(tabLayout,viewPager){tab,position->
            tab.text=labels[position].toString()

        }.attach()



    }



}




