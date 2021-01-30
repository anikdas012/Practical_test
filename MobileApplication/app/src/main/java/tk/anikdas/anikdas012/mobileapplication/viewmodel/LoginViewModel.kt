package tk.anikdas.anikdas012.mobileapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import tk.anikdas.anikdas012.mobileapplication.models.LogInDetails
import tk.anikdas.anikdas012.mobileapplication.network.LoginApi
import javax.inject.Inject

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

class LoginViewModel @Inject constructor(private val loginApi: LoginApi): ViewModel() {

    fun createUser(user: LogInDetails): LiveData<LogInDetails> {
        return LiveDataReactiveStreams.fromPublisher(
            loginApi.login(user)
                .onErrorReturn {
                    user.username = "Not found"
                    return@onErrorReturn user
                }
                .subscribeOn(Schedulers.io())
        )
    }
}