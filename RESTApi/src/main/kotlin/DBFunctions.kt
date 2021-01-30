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

fun getUsers(db: Database): List<User> {
    var users: MutableList<User> = ArrayList()
    transaction(db) {
        exec("SELECT * FROM USER;") {
            while (it.next()) {
                val user = User(it.getString(2),
                    it.getString(3),
                    it.getString(4),
                    it.getLong(5))
                users.add(user)
            }
        }
    }
    return users
}

fun updateUser(user: User, db: Database): String {
    if (user.email.isNullOrEmpty()) {
        return "Enter a valid 'email'"
    }
}