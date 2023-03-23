package Twitter.model.controller

import io.javalin.http.Context
import org.unq.TwitterSystem


class UserController() {

    lateinit var system : TwitterSystem
    constructor(system : TwitterSystem) : this() {
        this.system = system
    }

    fun getUser(ctx : Context ){
        val usuarioID = (ctx.pathParam("id"))
        println(usuarioID)
        val usuario = system.getUser(usuarioID)
        println(usuario)
        ctx.json(usuario)
    }



}