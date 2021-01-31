package tk.anikdas.anikdas012.mobileapplication.models

import com.google.gson.annotations.SerializedName

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

data class UserDetails(
    @SerializedName("name") var username: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("password") var password: String?,
    @SerializedName("confirmPassword") var confirmPassword: String?,
    @SerializedName("createdAt") var createdAt: Long? = null
)
