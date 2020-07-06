package com.aligkts.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligkts.photos.ui.photo.PhotosViewModel
import com.aligkts.photos.ui.photo.PhotosViewState
import com.aligkts.photos.ui.photo.PhotosAdapter
import com.aligkts.photos.common.ui.EndlessScrollListener
import com.aligkts.photos.common.ui.observeNonNull
import com.aligkts.photos.common.ui.runIfNull
import com.aligkts.photos.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    @Inject
    internal lateinit var photosAdapter: PhotosAdapter

    private lateinit var photosViewModel: PhotosViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        photosViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(PhotosViewModel::class.java)

        photosViewModel.getPhotosLiveData().observeNonNull(this) {
            renderPhotos(it)
        }

        savedInstanceState.runIfNull {
            photosViewModel.fetchPhotos(FIRST_PAGE)
        }
        initPhotosRecyclerview()
    }

    private fun initPhotosRecyclerview() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            adapter = photosAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(object : EndlessScrollListener(linearLayoutManager) {
                override fun onLoadMore(page: Int) {
                    photosViewModel.fetchPhotos(page)
                }
            })
        }
    }

    private fun renderPhotos(photosViewState: PhotosViewState) {
        with(binding) {
            viewState = photosViewState
            executePendingBindings()
        }
        if (photosAdapter.itemCount > 0)
            photosAdapter.setScrolledPhoto(photosViewState.getPhotos())
        else
            photosAdapter.setPhotos(photosViewState.getPhotos())
    }

    companion object {
        const val FIRST_PAGE = 1
    }
}
