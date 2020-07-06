package  com.aligkts.photos.common.di.module

import com.aligkts.photos.data.NetworkModule
import dagger.Module

@Module(
    includes = [NetworkModule::class]
)
class DataModule {

}