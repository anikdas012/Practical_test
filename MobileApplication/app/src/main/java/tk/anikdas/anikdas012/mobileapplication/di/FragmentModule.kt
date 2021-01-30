package tk.anikdas.anikdas012.mobileapplication.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import tk.anikdas.anikdas012.mobileapplication.network.CreateApi

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@Module
object FragmentModule {

    @FragmentScope
    @JvmStatic
    @Provides
    fun provideCreateApi(retrofit: Retrofit): CreateApi = retrofit.create(CreateApi::class.java)
}