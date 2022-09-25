package com.denizsimsek.newseventsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.denizsimsek.newseventsapp.R
import com.denizsimsek.newseventsapp.databinding.FragmentNewsFeedBinding
import com.denizsimsek.newseventsapp.viewmodel.NewsFeedViewModel

class NewsFeedFragment : Fragment() {

    private lateinit var binding:FragmentNewsFeedBinding
    private lateinit var viewModel:NewsFeedViewModel
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



        viewModel=ViewModelProvider(this).get(NewsFeedViewModel::class.java)
        viewModel.getNewsFromAPI()


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
