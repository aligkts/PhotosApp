package com.aligkts.photos.common.di.component

import android.app.Application
import com.aligkts.photos.PhotosApplication
import com.aligkts.photos.common.di.module.ActivityBuilderModule
import com.aligkts.photos.common.di.module.DataModule
import com.aligkts.photos.common.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        DataModule::class
    ]
)
interface AppComponent : AndroidInjector<PhotosApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<PhotosApplication>() {
        @BindsInstance
        abstract fun app(application: Application): Builder
    }
}