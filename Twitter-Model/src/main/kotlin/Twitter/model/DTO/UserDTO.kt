package Twitter.model.DTO

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