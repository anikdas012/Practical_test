package tk.anikdas.anikdas012.mobileapplication

import android.app.Application
import tk.anikdas.anikdas012.mobileapplication.di.AppComponent
import tk.anikdas.anikdas012.mobileapplication.di.DaggerAppComponent

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

class BaseApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}