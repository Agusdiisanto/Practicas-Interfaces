package Twitter.model

import Twitter.model.controller.TweetController
import Twitter.model.controller.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.unq.initTwitterSystem

fun main() {

    val app = Javalin.create().start(7000)
    val twitterSystem = initTwitterSystem()
    val userController = UserController(twitterSystem)
    val tweetController = TweetController(twitterSystem)


    app.routes {
        path("user"){
            path("{id}"){
                get(userController :: getUserWithId)
            }
        }


        path("search"){
            get(tweetController :: getTweetsWithText)
        }
        path("trendingTopics"){
            get(tweetController :: getTweetsWhitMostLikes)
        }

        path("tweet"){
            path("{id}"){
                get(tweetController :: getTweetByID)
            }
            post(tweetController :: addTweet)
        }


    }

}

