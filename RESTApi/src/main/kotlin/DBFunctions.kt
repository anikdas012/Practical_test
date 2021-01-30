import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun addUser(user: User, db: Database): String {
    user.pass = user.pass!!.sha256()
    var result: String? = null
    transaction(db) {
        val sql = "INSERT INTO User (UserName, Email, PasswordHash, CreatedAt) VALUES (\"${user.name}\", \"${user.email}\", \"${user.pass}\", ${user.time});"
        try {
            exec(sql)
            result = "Success"
        } catch (e: Exception) {
            result = "Failed"
        }

    }
    return result!!
}