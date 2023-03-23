package Twitter.model.DTO

import org.unq.TweetType

class SimpleTweetDTO(
    val id: String,
    val type: TwitterTypeDTO,
    val user: SimpleUserDTO,
    val content: String,
    val date: String,
    val repliesAmount: Int,
    val reTweetAmount: Int,
    val likes: MutableList<SimpleUserDTO>
) {

}
