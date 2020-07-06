package com.aligkts.photos.domain

import com.aligkts.photos.common.Resource
import com.aligkts.photos.data.photos.PhotosRepository
import com.aligkts.photos.ui.photo.model.PhotoItem
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 6,July,2020
 */
class FetchPhotosUseCase @Inject constructor(
    private val repository: PhotosRepository,
    private val mapper: PhotosMapper) {

    fun fetchPhotos(page: Int): Observable<Resource<List<PhotoItem>>> {
        return repository
            .fetchPhotos(page)
            .map { resource ->
                Resource(
                    status = resource.status,
                    data = resource.data?.let { mapper.mapFrom(it) },
                    error = resource.error
                )
            }
    }
}