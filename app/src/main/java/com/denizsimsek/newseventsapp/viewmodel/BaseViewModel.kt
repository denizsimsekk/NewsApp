package com.denizsimsek.newseventsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

//to use coroutine with several viewmodels so that every viewmodel extends only baseviewmodel
abstract class BaseViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {


    private val job= Job()

    //do the job then go back to main thread
    override val coroutineContext: CoroutineContext
        get() = job+Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }




}
