package Twitter.model.controller

import Twitter.model.DTO.ErrorDTO.ErrorDTO
import Twitter.model.DTO.TweetDTO.AddTweetDTO
import Twitter.model.DTO.UsuarioDTO.DTOMapper
import Twitter.model.DTO.TweetDTO.TweetsResultDTO
import io.javalin.http.Context
import org.unq.DraftTweet
import org.unq.Tweet
import org.unq.TweetException
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
        } catch (e: Exception){}
    }

    fun getTweetsWhitMostLikes(ctx : Context){
        try{
            val result = system.getTrendingTopics()
            val dtoResult = TweetsResultDTO(result.map{mapper.mapTweetToSimpleTweetDTO(it)}.toMutableList())
            ctx.json(dtoResult)
        } catch (e:Exception){}
    }

    fun addTweet(ctx : Context){

        // Validacion de usuario FALTA

        val newTweet = ctx.bodyAsClass<AddTweetDTO>(AddTweetDTO::class.java)
        val draft = DraftTweet("u_2",newTweet.content,newTweet.image)
        val dto = mapper.mapTweetToTweetDTO(system.addNewTweet(draft))
        ctx.json(dto)

    }

    fun getTweetByID(ctx : Context){
        val tweetID = ctx.pathParam("id")
        try{
            val dto = mapper.mapTweetToTweetDTO(system.getTweet(tweetID))
            ctx.json(dto)
        } catch (e: TweetException){
            ctx.status(404)
            ctx.json(ErrorDTO(e.message!!))
        }

    }








}