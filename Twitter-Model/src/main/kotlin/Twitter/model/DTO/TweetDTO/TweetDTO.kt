package Twitter.model.DTO.TweetDTO

import Twitter.model.DTO.UsuarioDTO.SimpleUserDTO
import Twitter.model.DTO.UsuarioDTO.UserDTO
import org.unq.ReTweet
import org.unq.User

class TweetDTO( val id : String ,            val type : TwitterTypeDTO     ,
                val user : SimpleUserDTO ,   val content : String          ,
                val date : String ,          val replies : MutableList<SimpleTweetDTO>  ,
                val reTweet: MutableList<SimpleTweetDTO>, val likes : MutableList<SimpleUserDTO>){






}