package tk.anikdas.anikdas012.mobileapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import tk.anikdas.anikdas012.mobileapplication.models.UserDetails
import tk.anikdas.anikdas012.mobileapplication.network.CreateApi
import javax.inject.Inject

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

class CreateViewModel @Inject constructor(private val createApi: CreateApi): ViewModel() {

    fun createUser(user: UserDetails): LiveData<UserDetails> {
        return LiveDataReactiveStreams.fromPublisher(
            createApi.createAccount(user)
                .onErrorReturn {
                    user.createdAt = -1
                    return@onErrorReturn user
                }
                .subscribeOn(Schedulers.io())
        )
    }
}