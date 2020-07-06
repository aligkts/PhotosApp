package com.aligkts.photos.common.di.module

import com.aligkts.photos.MainActivity
import com.aligkts.photos.common.di.scope.ActivityScope
import com.aligkts.photos.ui.photo.PhotosActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [PhotosActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}