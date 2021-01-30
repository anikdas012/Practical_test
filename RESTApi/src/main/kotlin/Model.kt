data class User(
    var name: String? = "null",
    var email: String?,
    var password: String?,
    var time: Long?
)

data class UserDetails(
    var name: String,
    var email: String,
    var password: String,
    var confirmPassword: String,
    var time: Long?
)