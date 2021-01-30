package tk.anikdas.anikdas012.mobileapplication.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tk.anikdas.anikdas012.mobileapplication.viewmodel.CreateViewModel

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@Module
abstract class FragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateViewModel::class)
    abstract fun bindPostViewModel(viewModel: CreateViewModel): ViewModel
}