package tk.anikdas.anikdas012.mobileapplication.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import tk.anikdas.anikdas012.mobileapplication.viewmodel.ViewModelProvidersFactory

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProvidersFactory: ViewModelProvidersFactory) : ViewModelProvider.Factory
}