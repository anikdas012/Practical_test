package tk.anikdas.anikdas012.mobileapplication.network

import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.POST
import tk.anikdas.anikdas012.mobileapplication.models.LogInDetails

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

interface LoginApi {

    @POST("loginUser")
    fun login(@Body userDetails: LogInDetails): Flowable<LogInDetails>
}