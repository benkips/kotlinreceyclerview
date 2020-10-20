package com.mabnets.kotlinreceyclerview.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mabnets.kotlinreceyclerview.repo.Myinforepo
import com.mabnets.kotlinreceyclerview.viewmodel.MyinfoviewModel

@Suppress("UNCHECKED_CAST")
class myviewmodelfactory(
    private  val repository :Myinforepo
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyinfoviewModel(repository) as T
    }
}