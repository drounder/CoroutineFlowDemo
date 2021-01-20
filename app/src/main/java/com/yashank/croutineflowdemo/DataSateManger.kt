package com.yashank.croutineflowdemo

/**Created by Yashank Rathore on 20,January,2021 yashank.mindiii@gmail.com **/

sealed class DataSateManger{
    data class Success<out T>(val data : T) : DataSateManger()
    data class Error(val msg : String) : DataSateManger()
}