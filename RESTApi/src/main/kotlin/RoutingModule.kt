import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.Database

fun Route.api() {
    val db: Database = connectDB()
    route("/api") {
        post ("/user") {
            var user = call.receive<User>()
            user.time = System.currentTimeMillis()
            val result = addUser(user, db)
            call.respond(HttpStatusCode.OK, result)
        }
        get("/user") {
            val users = Gson().toJson(getUsers(db))
            call.respond(HttpStatusCode.OK, users)
        }
    }
}
