package Twitter.model

import Twitter.model.controller.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.unq.User
import org.unq.initTwitterSystem

fun main() {

    val app = Javalin.create().start(7000)
    val twitterSystem = initTwitterSystem()
    val userControler = UserController(twitterSystem)

    // Para encontrar un ID
    println(twitterSystem.users.get(1).id)

    app.routes {

        path("/user"){


            path("id"){
                get(userControler :: getUser)
            }

        }

    }

}

