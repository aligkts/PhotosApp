package com.aligkts.photos.data.photos.response


import com.google.gson.annotations.SerializedName

data class RecentPhotosResponse(

    @SerializedName("photos")
    val photos : RecentPhotos?,

    @SerializedName("stat")
    val stat : String?

)