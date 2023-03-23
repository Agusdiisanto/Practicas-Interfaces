package Twitter.model.DTO

import org.unq.Tweet
import org.unq.TweetType
import org.unq.TwitterSystem
import org.unq.User

class DTOMapper() {

    lateinit var system : TwitterSystem

    constructor(system : TwitterSystem) : this() {
        this.system = system
    }

    fun mapUserToUserDTO(user: User): UserDTO {
        val tweets = this.system.tweets
        val followers = user.followers.map { mapUserToSimpleUserDTO(it) }
        val following = user.following.map { mapUserToSimpleUserDTO(it) }
        val userTweets = tweets.filter { t -> t.user.id == user.id }
        val tweetsDTO = userTweets.map {mapTweetToSimpleTweetDTO(it)}
        return UserDTO(
            user.id,
            user.username,
            user.email,
            user.image,
            user.backgroundImage,
            followers.toMutableList(),
            following.toMutableList(),
            tweetsDTO.toMutableList()
        )
    }

    private fun mapUserToSimpleUserDTO(user: User): SimpleUserDTO {
        return SimpleUserDTO(
            user.id, user.username
        )
    }

    private fun mapTweetToSimpleTweetDTO(tweet: Tweet): SimpleTweetDTO {
        val user = mapUserToSimpleUserDTO(tweet.user)
        val likes = tweet.likes.map { mapUserToSimpleUserDTO(it) }
        val type = mapTweetTypeToTwitterTypeDTO(tweet.type)
        return SimpleTweetDTO(
            tweet.id,
            type,
            user,
            tweet.content,
            tweet.date.toString(),
            tweet.replies.size,
            tweet.reTweets.size,
            likes.toMutableList()
        )
    }

    private fun mapTweetTypeToTwitterTypeDTO(type: TweetType): TwitterTypeDTO {
        return TwitterTypeDTO(
            type.tweet?.content,
            type.image
        )
    }
}