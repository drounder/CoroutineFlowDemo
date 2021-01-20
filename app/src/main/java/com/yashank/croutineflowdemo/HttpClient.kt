package com.yashank.croutineflowdemo

import com.yashank.croutineflowdemo.apirequest.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**Created by Yashank Rathore on 20,January,2021 yashank.mindiii@gmail.com **/

object HttpClient {
    fun getRetroInstance(): ApiClient{
        return Retrofit.Builder()
            .baseUrl("https://picsum.photos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiClient::class.java)
    }

}