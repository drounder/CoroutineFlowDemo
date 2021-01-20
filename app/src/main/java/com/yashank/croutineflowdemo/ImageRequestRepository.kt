package com.yashank.croutineflowdemo

import com.yashank.croutineflowdemo.apirequest.ApiClient
import com.yashank.croutineflowdemo.modal.ImagesModalItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**Created by Yashank Rathore on 20,January,2021 yashank.mindiii@gmail.com **/

class ImageRequestRepository(val apiClient: ApiClient) {
    suspend fun requestImageLoading():Response<ArrayList<ImagesModalItem>>{
        return apiClient.getImages()
    }
}