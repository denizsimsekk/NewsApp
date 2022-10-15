package com.denizsimsek.newseventsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denizsimsek.newseventsapp.R
import com.denizsimsek.newseventsapp.adapter.NewsAdapter
import com.denizsimsek.newseventsapp.databinding.FragmentNewsFeedBinding
import com.denizsimsek.newseventsapp.model.News
import com.denizsimsek.newseventsapp.viewmodel.NewsFeedViewModel

class NewsFeedFragment : Fragment() {

    private lateinit var binding:FragmentNewsFeedBinding
    private lateinit var viewModel:NewsFeedViewModel
    private var newsArrayList=ArrayList<News>()

    /*private val swipeCallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT)
    {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val action=NewsFeedFragmentDirections.actionNewsFeedFragmentToEventsFragment()
            Navigation.findNavController(viewHolder.itemView).navigate(action)
        }

    }*/

    private var adapter=NewsAdapter(newsArrayList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentNewsFeedBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newsRecyclerView.layoutManager=LinearLayoutManager(context)
        binding.newsRecyclerView.adapter=adapter

        viewModel=ViewModelProvider(this).get(NewsFeedViewModel::class.java)
        viewModel.getNewsFromAPI()

        binding.newsFeedSwipeRefresh.setOnRefreshListener {
            viewModel.getNewsFromAPI()
            binding.newsRecyclerView.visibility=View.GONE
            binding.newsFeedProgress.visibility=View.VISIBLE
            binding.newsFeedErrorText.visibility=View.GONE
            binding.newsFeedSwipeRefresh.isRefreshing=false
        }

        observeLiveData()
    }

    private fun observeLiveData()
    {
        viewModel.newsList.observe(viewLifecycleOwner)
        {
            newsList->
            newsList?.let {
                binding.newsRecyclerView.visibility=View.VISIBLE
                //SET ADAPTER
                adapter.refreshNewsList(newsList.newsList)

            }


        }
        viewModel.newsFeedError.observe(viewLifecycleOwner)
        {
            error->
            error?.let {
                if(it)
                {
                    binding.newsFeedErrorText.visibility=View.VISIBLE

                }
                else
                {
                    binding.newsFeedErrorText.visibility=View.GONE
                }
            }
        }
        viewModel.newsFeedLoading.observe(viewLifecycleOwner)
        {
            loading->
            loading?.let {
                if(it)
                {
                    binding.newsFeedProgress.visibility=View.VISIBLE
                }
                else
                {
                    binding.newsFeedProgress.visibility=View.GONE

                }
            }
        }
    }

}
