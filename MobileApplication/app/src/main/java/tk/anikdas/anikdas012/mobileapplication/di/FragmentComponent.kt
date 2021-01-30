package tk.anikdas.anikdas012.mobileapplication.di

import dagger.Subcomponent
import tk.anikdas.anikdas012.mobileapplication.MainActivity
import tk.anikdas.anikdas012.mobileapplication.ui.CreateFragment

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@FragmentScope
@Subcomponent(
        modules = [FragmentModule::class,
                    FragmentViewModelModule::class]
)
interface FragmentComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentComponent
    }

    fun inject(fragment: CreateFragment)
}