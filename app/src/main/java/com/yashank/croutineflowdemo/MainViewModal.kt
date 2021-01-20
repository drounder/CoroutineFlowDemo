package com.yashank.croutineflowdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yashank.croutineflowdemo.modal.ImagesModalItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

/**Created by Yashank Rathore on 20,January,2021 yashank.mindiii@gmail.com **/

class MainViewModal(private val imageRequestRepository: ImageRequestRepository) : ViewModel() {
    lateinit var flow: Flow<ArrayList<ImagesModalItem>?>
    private val _imageListObserver by lazy {
        MutableLiveData<DataSateManger>()
    }

    init {
        Log.d("fasfasas", ":init ")
        requestForAllImages()
    }
    public fun imageListObserver() : LiveData<DataSateManger>{
        return  _imageListObserver
    }


    fun requestForAllImages(){
        viewModelScope.launch {
            if(imageRequestRepository.requestImageLoading().isSuccessful){
                flow =  flow {
                   emit(imageRequestRepository.requestImageLoading().body())
               }
                Log.d("fasfasas", ":getAllImages ")
                getAllImages()
            }else{
                _imageListObserver.postValue(DataSateManger.Error("API Request Failed"))
            }
        }

    }

    fun getAllImages(){
        viewModelScope.launch {
            Log.d("fasfasas", ":launch ")
            if(::flow.isInitialized){
                Log.d("fasfasas", ":isInitialized ")
                flow.collect {
                    Log.d("fasfasas", ":collect ")
                    it?.let {
                        Log.d("fasfasas", ":let ")
                        _imageListObserver.postValue(DataSateManger.Success(it))
                    }
                }
            }
        }
    }


}