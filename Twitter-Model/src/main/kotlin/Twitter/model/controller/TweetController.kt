package Twitter.model.controller

import Twitter.model.DTO.DTOMapper
import Twitter.model.DTO.TweetsResultDTO
import io.javalin.http.Context
import org.unq.TwitterSystem

class TweetController() {

    private lateinit var system : TwitterSystem
    lateinit var mapper: DTOMapper
    constructor(system : TwitterSystem) : this() {
        this.system = system
        this.mapper = DTOMapper(system)
    }

    fun getTweetsWithText(ctx: Context) {
        val text = ctx.queryParam("text")
        //consultar en caso de nulo
        try{
            val result = system.search(text!!)
            val dtoResult = TweetsResultDTO(result.map{mapper.mapTweetToSimpleTweetDTO(it)}.toMutableList())
            ctx.json(dtoResult)
        } catch (e:java.lang.Exception){}
    }

}