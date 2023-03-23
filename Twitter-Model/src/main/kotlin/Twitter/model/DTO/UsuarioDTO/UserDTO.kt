package Twitter.model.DTO.UsuarioDTO

import Twitter.model.DTO.TweetDTO.SimpleTweetDTO

class UserDTO(
    val id: String,
    val username: String,
    val email: String,
    val image: String,
    val backgroundImage: String,
    val followers: MutableList<SimpleUserDTO>,
    val followings: MutableList<SimpleUserDTO>,
    val tweets: MutableList<SimpleTweetDTO>
) {
}