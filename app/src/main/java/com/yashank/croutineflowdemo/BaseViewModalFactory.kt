package com.yashank.croutineflowdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

/**Created by Yashank Rathore on 20,January,2021 yashank.mindiii@gmail.com **/

@Suppress("UNCHECKED_CAST")
class BaseViewModalFactory<T>(val data: T) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

         if(modelClass.isAssignableFrom(MainViewModal::class.java)){
             return MainViewModal(data as ImageRequestRepository) as T
         }else{
             throw IllegalArgumentException("Not Found View Modal Class")
         }
    }
}