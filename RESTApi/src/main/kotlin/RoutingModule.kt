import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.api() {
    route("/api") {
        get("/") {
            call.respond(HttpStatusCode.OK, "HTML::index")
        }
    }
}