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
    user.password = user.password!!.sha256()
    var result: String? = null
    transaction(db) {
        val sql = "INSERT INTO User (UserName, Email, PasswordHash, CreatedAt) VALUES (\"${user.name}\", \"${user.email}\", \"${user.password}\", ${user.time});"
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
    var result: String? = null
    transaction(db) {
        val sql = "UPDATE User SET UserName = \"${user.name}\", PasswordHash = \"${user.password?.sha256()}\" WHERE Email = \"${user.email}\";"
        try {
            exec(sql)
            exec("SELECT UserName, Email FROM User WHERE Email = \"${user.email}\";") {
                while (it.next()) {
                    result = "{\n" +
                            "   \"name\": \"${it.getString(1)}\"\n" +
                            "   \"email\": \"${it.getString(2)}\"\n" +
                            "}"
                }
            }
        } catch (e: Exception) {
            result = "Not updated"
        }
    }
    return result!!
}

fun deleteUser(user: User, db: Database): String {
    if (user.name.isNullOrEmpty() || user.email.isNullOrBlank()) {
        return "Not deleted \nEnter a valid 'name' and 'email'"
    }
    var result: String? = null
    transaction(db) {
        val sql = "DELETE FROM User WHERE UserName = \"${user.name!!}\" and Email = \"${user.email!!}\""
        try {
            exec("SELECT UserName FROM USER WHERE UserName = \"${user.name!!}\" and Email = \"${user.email!!}\";") {
                if (it.next()) {
                    exec(sql)
                    result = "Deleted"
                } else {
                    result = "Not deleted \n" +
                            "Enter a valid 'name' and 'email'"
                }
            }
        } catch (e: Exception) {
            println("*** $e")
            result = "Not deleted"
        }
    }
    return result!!
}

fun resetUserPass(user: User, db: Database): String {
    var result: String? = null
    transaction(db) {
        val sql = "UPDATE User SET PasswordHash = \"${user.password?.sha256()}\" WHERE Email = \"${user.email}\";"
        try {
            exec(sql)
            exec("SELECT UserName, Email FROM User WHERE Email = \"${user.email}\";") {
                while (it.next()) {
                    result = "{\n" +
                            "   \"name\": \"${it.getString(1)}\"\n" +
                            "   \"email\": \"${it.getString(2)}\"\n" +
                            "}"
                }
            }
        } catch (e: Exception) {
            result = "Not updated"
        }
    }
    return result!!
}

fun createUser(user: UserDetails, db: Database): String {
    if (user.password != user.confirmPassword) {
        return "{\n" +
                "    \"name\": \"${user.name}\",\n" +
                "    \"email\": \"${user.email}\",\n" +
                "    \"createdAt\": \"-1\"\n" +
                "}"
    }
    user.password = user.password.sha256()
    var result: String? = null
    transaction(db) {
        val sql = "INSERT INTO User (UserName, Email, PasswordHash, CreatedAt) VALUES (\"${user.name}\", \"${user.email}\", \"${user.password}\", ${user.time});"
        try {
            exec(sql)
            result = "{\n" +
                    "    \"name\": \"${user.name}\",\n" +
                    "    \"email\": \"${user.email}\",\n" +
                    "    \"createdAt\": ${user.time}\n" +
                    "}"
        } catch (e: Exception) {
            user.time = -1
            result = "{\n" +
                    "    \"name\": \"${user.name}\",\n" +
                    "    \"email\": \"${user.email}\",\n" +
                    "    \"createdAt\": ${user.time}\n" +
                    "}"
        }

    }
    return result!!
}