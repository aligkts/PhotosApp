package com.aligkts.photos.data.photos

import com.aligkts.photos.common.Resource
import com.aligkts.photos.common.ui.applyLoading
import com.aligkts.photos.data.photos.response.RecentPhotosResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class PhotosRepository @Inject constructor(private val photosRemoteDataSource: PhotosRemoteDataSource) {

    fun fetchPhotos(page: Int): Observable<Resource<RecentPhotosResponse>> =
        photosRemoteDataSource
            .fetchPhotos(page)
            .map { Resource.success(it) }
            .onErrorReturn { Resource.error(it) }
            .subscribeOn(Schedulers.io())
            .compose(applyLoading())
}