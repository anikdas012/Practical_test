import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

fun connectDB(): Database {
    val db = Database.connect("jdbc:sqlite:database\\todosqli.db" , "org.sqlite.JDBC")
    TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
    return db
}

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