package com.mabnets.kotlinreceyclerview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mabnets.kotlinreceyclerview.utils.Coroutines
import com.mabnets.kotlinreceyclerview.models.Myinfo
import com.mabnets.kotlinreceyclerview.repo.Myinforepo
import kotlinx.coroutines.Job

class MyinfoviewModel(private val repository: Myinforepo) : ViewModel() {
    // TODO: Implement the ViewModel
    private val _myinfo = MutableLiveData<List<Myinfo>>()
    private lateinit var job: Job

    val myinfo: LiveData<List<Myinfo>>
        get() = _myinfo

    fun getmydata() {
        job = Coroutines.ioThenMain(
            { repository.getmyinfodata()  },
            {_myinfo.value = it }
        )
    }

    override fun onCleared() {
        if(::job.isInitialized)job.cancel()
        super.onCleared()
    }
}