package com.aligkts.photos.ui.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aligkts.photos.common.Resource
import com.aligkts.photos.common.RxAwareViewModel
import com.aligkts.photos.common.ui.plusAssign
import com.aligkts.photos.domain.FetchPhotosUseCase
import com.aligkts.photos.ui.photo.model.PhotoItem
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


/**
 * Created by Ali Göktaş on 6,July,2020
 */
class PhotosViewModel @Inject constructor(private val fetchPhotosUseCase: FetchPhotosUseCase) :
    RxAwareViewModel() {

    private val photosLiveData = MutableLiveData<PhotosViewState>()

    fun getPhotosLiveData(): LiveData<PhotosViewState> = photosLiveData

    fun fetchPhotos(page: Int) {
        fetchPhotosUseCase
            .fetchPhotos(page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onPhotosResultReady)
            .also {
                disposable += it
            }
    }

    private fun onPhotosResultReady(resource: Resource<List<PhotoItem>>) {
        photosLiveData.value = PhotosViewState(
            status = resource.status,
            error = resource.error,
            data = resource.data
        )
    }
}