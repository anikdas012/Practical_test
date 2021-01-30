package tk.anikdas.anikdas012.mobileapplication.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tk.anikdas.anikdas012.mobileapplication.viewmodel.CreateViewModel
import tk.anikdas.anikdas012.mobileapplication.viewmodel.LoginViewModel

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@Module
abstract class FragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateViewModel::class)
    abstract fun bindCreateViewModel(viewModel: CreateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}