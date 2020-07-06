package com.aligkts.photos.ui.photo

import com.aligkts.photos.common.Status
import com.aligkts.photos.ui.photo.model.PhotoItem

/**
 * Created by Ali Göktaş on 6,July,2020
 */
class PhotosViewState(
    val status: Status,
    val error: Throwable? = null,
    val data: List<PhotoItem>? = null) {
    fun getPhotos() = data ?: mutableListOf()

    fun isLoading() = status == Status.LOADING

    fun getErrorMessage() = error?.message

    fun shouldShowErrorMessage() = error != null
}