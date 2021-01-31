package tk.anikdas.anikdas012.mobileapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import tk.anikdas.anikdas012.mobileapplication.models.ResetPasswordDetails
import tk.anikdas.anikdas012.mobileapplication.network.ResetPasswordApi
import javax.inject.Inject

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

class ResetPasswordViewModel @Inject constructor(private val resetApi: ResetPasswordApi): ViewModel() {

    fun resetPass(user: ResetPasswordDetails): LiveData<ResetPasswordDetails> {
        return LiveDataReactiveStreams.fromPublisher(
            resetApi.resetPassword(user)
                .onErrorReturn {
                    user.username = "Not updated"
                    return@onErrorReturn user
                }
                .subscribeOn(Schedulers.io())
        )
    }
}