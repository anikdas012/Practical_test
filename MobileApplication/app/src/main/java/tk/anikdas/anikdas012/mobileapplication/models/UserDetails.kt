package tk.anikdas.anikdas012.mobileapplication.models

import com.google.gson.annotations.SerializedName

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

data class UserDetails(
    @SerializedName("name") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("confirmPassword") val confirmPassword: String?,
    @SerializedName("createdAt") val createdAt: Long?
)
