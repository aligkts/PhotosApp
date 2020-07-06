package com.aligkts.photos.ui.photo

import com.aligkts.photos.common.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by Ali Göktaş on 6,July,2020
 */
@Module
class PhotosActivityModule {

    @Provides
    @ActivityScope
    fun providePhotosAdapter(): PhotosAdapter {
        return PhotosAdapter()
    }
}