package tk.anikdas.anikdas012.mobileapplication.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@Singleton
@Component(
    modules = [AppModule::class,
                ViewModelFactoryModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }

    fun fragmentComponent(): FragmentComponent.Builder
}