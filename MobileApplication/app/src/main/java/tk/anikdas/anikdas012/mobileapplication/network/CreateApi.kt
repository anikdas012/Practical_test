package tk.anikdas.anikdas012.mobileapplication.network

import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import tk.anikdas.anikdas012.mobileapplication.models.UserDetails

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

interface CreateApi {

    @POST("createUser")
    fun createAccount(@Body userDetails: UserDetails): Flowable<UserDetails>
}