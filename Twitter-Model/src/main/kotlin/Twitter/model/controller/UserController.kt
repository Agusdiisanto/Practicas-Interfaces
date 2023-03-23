package Twitter.model.controller

import Twitter.model.DTO.DTOMapper
import io.javalin.http.Context
import org.unq.TwitterSystem
import org.unq.UserException


class UserController() {

    private lateinit var system : TwitterSystem
    lateinit var mapper: DTOMapper
    constructor(system : TwitterSystem) : this() {
        this.system = system
        this.mapper = DTOMapper(system)
    }

    fun getUserWithId(ctx : Context ){
        val usuarioID = (ctx.pathParam("id"))
        try{
            val usuario = mapper.mapUserToUserDTO(system.getUser(usuarioID))
            ctx.json(usuario)

        } catch (e: UserException){
            ctx.status(404)
            ctx.json(e.message!!)
        }

    }



}