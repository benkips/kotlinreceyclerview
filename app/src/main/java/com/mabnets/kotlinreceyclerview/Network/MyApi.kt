package com.mabnets.kotlinreceyclerview.Network

import com.mabnets.kotlinreceyclerview.models.Myinfo
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {
    @GET("downloadtest.php")
    suspend fun getkdata(): Response<List<Myinfo>>

    companion object {
        operator fun invoke(): MyApi {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okclients = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder().client(okclients)
                .baseUrl("http://kilicom.mabnets.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}