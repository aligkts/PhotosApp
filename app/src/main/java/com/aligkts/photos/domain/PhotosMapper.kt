package com.aligkts.photos.domain

import com.aligkts.photos.common.Mapper
import com.aligkts.photos.data.photos.response.RecentPhotosResponse
import com.aligkts.photos.ui.photo.model.PhotoItem
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 6,July,2020
 */

class PhotosMapper @Inject constructor() : Mapper<RecentPhotosResponse, List<PhotoItem>> {

    override fun mapFrom(type: RecentPhotosResponse): List<PhotoItem> {
        type.photos.let {
            it?.let {
                return it.photoModel.map {
                    PhotoItem(imageUrl = it.url_m)
                }
            }
        }
        return emptyList()
    }
}
