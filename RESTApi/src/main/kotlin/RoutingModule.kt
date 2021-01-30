import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import java.sql.Connection

fun Route.api() {
    val db: Database = connectDB()
    route("/api") {
        get("/") {
            call.respond(HttpStatusCode.OK, "HTML::index")
        }
    }
}

fun connectDB(): Database {
    val db = Database.connect("jdbc:sqlite:database\\todosqli.db" , "org.sqlite.JDBC")
    TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
    return db
}
