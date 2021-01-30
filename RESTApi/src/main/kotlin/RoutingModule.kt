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
            val user = call.receive<User>()
            user.time = System.currentTimeMillis()
            val result = addUser(user, db)
            call.respond(HttpStatusCode.OK, result)
        }
        get("/user") {
            val users = Gson().toJson(getUsers(db))
            call.respond(HttpStatusCode.OK, users)
        }
        put ("/user") {
            val user = call.receive<User>()
            val result = updateUser(user, db)
            call.respond(HttpStatusCode.OK, result)
        }
        delete ("/user") {
            val user = call.receive<User>()
            val result = deleteUser(user, db)
            call.respond(HttpStatusCode.OK, result)
        }
        put ("/resetPass") {
            val user = call.receive<User>()
            val result = resetUserPass(user, db)
            call.respond(HttpStatusCode.OK, result)
        }
        post ("/createUser") {
            val user = call.receive<UserDetails>()
            user.time = System.currentTimeMillis()
            val result = createUser(user, db)
            call.respond(HttpStatusCode.OK, result)
        }
        post ("/loginUser") {
            val user = call.receive<UserLogin>()
            val result = loginUser(user, db)
            call.respond(HttpStatusCode.OK, result)
        }
    }
}
