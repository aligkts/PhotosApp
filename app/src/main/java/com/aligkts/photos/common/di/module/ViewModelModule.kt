package com.aligkts.photos.common.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aligkts.photos.common.di.ViewModelFactory
import com.aligkts.photos.common.di.key.ViewModelKey
import com.aligkts.photos.ui.photo.PhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(PhotosViewModel::class)
    abstract fun providePhotosViewModel(photosViewModel: PhotosViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}