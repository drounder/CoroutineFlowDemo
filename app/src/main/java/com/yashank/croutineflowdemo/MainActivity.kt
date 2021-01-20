package com.yashank.croutineflowdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.yashank.croutineflowdemo.adapter.ImageAdapter
import com.yashank.croutineflowdemo.databinding.ActivityMainBinding
import com.yashank.croutineflowdemo.modal.ImagesModalItem
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var viewModal: MainViewModal


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val client = ImageRequestRepository(HttpClient.getRetroInstance())
        val factory = BaseViewModalFactory(client)
        viewModal = ViewModelProvider(this,factory).get(MainViewModal::class.java)

        viewModal.imageListObserver().observe(this,
            Observer<DataSateManger> {
                when (it) {
                    is DataSateManger.Success<*> -> {
                        val list = it.data as ArrayList<ImagesModalItem>

                        Log.d("fasfasas", "Success: ${it.data}")
                        binding.recycler.adapter = ImageAdapter(list)

                    }
                    is DataSateManger.Error -> {
                        Log.d("fasfasas", "Error: ${it.msg}")
                    }
                }


            })

        Log.d("fasfasas", ":onCreate getAllImages ")
    }

    fun btnOnClick(view: View) {
        viewModal.requestForAllImages()
    }




}