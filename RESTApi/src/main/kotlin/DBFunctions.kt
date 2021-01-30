import org.jetbrains.exposed.sql.Database

fun addUser(user: User, db: Database): String {
    user.pass = user.pass!!.sha256()
}