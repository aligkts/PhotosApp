package com.aligkts.photos.data.photos

import com.aligkts.photos.data.PhotosRestInterface
import javax.inject.Inject

class PhotosRemoteDataSource @Inject constructor(private val restInterface: PhotosRestInterface) {

    fun fetchPhotos(page: Int) = restInterface.fetchPhotos(page)

}