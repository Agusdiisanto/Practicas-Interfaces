package Twitter.model.controller

import Twitter.model.DTO.DTOMapper
import io.javalin.http.Context
import org.unq.TwitterSystem


class UserController() {

    private lateinit var system : TwitterSystem
    lateinit var mapper: DTOMapper
    constructor(system : TwitterSystem) : this() {
        this.system = system
        this.mapper = DTOMapper(system)
    }

    fun getUser(ctx : Context ){
        val usuarioID = (ctx.pathParam("id"))

        val usuario = mapper.mapUserToUserDTO(system.getUser(usuarioID))

        ctx.json(usuario)
    }



}