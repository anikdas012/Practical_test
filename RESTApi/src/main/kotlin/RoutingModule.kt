import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import java.sql.Connection

fun Route.api() {
    val db: Database = connectDB()
    route("/api") {
        post ("/user") {
            var user = call.receive<User>()
            user.time = System.currentTimeMillis()
            val result = addUser(user, db)
            call.respond(HttpStatusCode.OK, result)
        }
    }
}

fun connectDB(): Database {
    val db = Database.connect("jdbc:sqlite:database\\todosqli.db" , "org.sqlite.JDBC")
    TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
    return db
}
