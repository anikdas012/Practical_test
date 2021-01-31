package tk.anikdas.anikdas012.mobileapplication.network

import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.POST
import tk.anikdas.anikdas012.mobileapplication.models.ResetPasswordDetails

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

interface ResetPasswordApi {

    @POST("resetPassword")
    fun resetPassword(@Body details: ResetPasswordDetails): Flowable<ResetPasswordDetails>
}