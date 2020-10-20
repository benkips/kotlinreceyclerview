package com.mabnets.kotlinreceyclerview.repo

import com.mabnets.kotlinreceyclerview.Network.MyApi
import com.mabnets.kotlinreceyclerview.utils.SafeApiRequest

class Myinforepo(private  val api: MyApi)  :
    SafeApiRequest() {
    suspend fun getmyinfodata()=apiRequest { api.getkdata() }
}