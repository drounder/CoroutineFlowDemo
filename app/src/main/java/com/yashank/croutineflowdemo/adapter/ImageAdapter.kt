package com.yashank.croutineflowdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yashank.croutineflowdemo.R
import com.yashank.croutineflowdemo.databinding.ImagesLayoutBinding
import com.yashank.croutineflowdemo.modal.ImagesModalItem

/**Created by Yashank Rathore on 20,January,2021 yashank.mindiii@gmail.com **/

class ImageAdapter(val imageList: ArrayList<ImagesModalItem>) : RecyclerView.Adapter<ImageAdapter.ImageHolder>() {
    lateinit var context: Context

    inner class ImageHolder(val binding: ImagesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        context = parent.context
        val binding = DataBindingUtil.inflate<ImagesLayoutBinding>(
            LayoutInflater.from(context),
            R.layout.images_layout,
            parent,
            false
        )
        return ImageHolder(binding)
    }

    override fun getItemCount() = imageList.size

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val data = imageList[position]
        Glide.with(context).load(data.downloadUrl).into(holder.binding.ivShowImages)
        holder.binding.tvShowImageName.text = data.author

    }
}