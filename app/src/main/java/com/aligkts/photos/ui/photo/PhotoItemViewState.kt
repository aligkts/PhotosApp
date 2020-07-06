package com.aligkts.photos.ui.photo

import com.aligkts.photos.ui.photo.model.PhotoItem

/**
 * Created by Ali Göktaş on 6,July,2020
 */
class PhotoItemViewState(private val photoItem: PhotoItem) {

    fun getImageUrl() = photoItem.imageUrl

}