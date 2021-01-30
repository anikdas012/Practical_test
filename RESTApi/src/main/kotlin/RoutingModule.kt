import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.Database

fun Route.api() {
    val db: Database = connectDB()
    route("/api") {
        get("/") {
            call.respond(HttpStatusCode.OK, "HTML::index")
        }
    }
}

fun connectDB(): Database {
    TODO("Not yet implemented")
}
