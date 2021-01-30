package tk.anikdas.anikdas012.mobileapplication.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import tk.anikdas.anikdas012.mobileapplication.network.CreateApi
import tk.anikdas.anikdas012.mobileapplication.network.LoginApi
import tk.anikdas.anikdas012.mobileapplication.network.ResetPasswordApi

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

    @FragmentScope
    @JvmStatic
    @Provides
    fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)

    @FragmentScope
    @JvmStatic
    @Provides
    fun provideResetPasswordApi(retrofit: Retrofit): ResetPasswordApi = retrofit.create(ResetPasswordApi::class.java)
}