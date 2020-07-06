package com.aligkts.photos.data

import com.aligkts.photos.data.photos.response.RecentPhotosResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosRestInterface {

    @GET("services/rest")
    fun fetchPhotos(@Query("page") page : Int) : Observable<RecentPhotosResponse>
}