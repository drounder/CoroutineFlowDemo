package com.yashank.croutineflowdemo.apirequest

import com.yashank.croutineflowdemo.modal.ImagesModalItem
import retrofit2.Response
import retrofit2.http.GET

/**Created by Yashank Rathore on 20,January,2021 yashank.mindiii@gmail.com **/

interface ApiClient {
    @GET("v2/list")
    suspend fun getImages() : Response<ArrayList<ImagesModalItem>>
}