package com.yashank.croutineflowdemo.modal


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName


data class ImagesModalItem(
    @SerializedName("author")
    var author: String?,
    @SerializedName("download_url")
    var downloadUrl: String?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("width")
    var width: Int?


){

}