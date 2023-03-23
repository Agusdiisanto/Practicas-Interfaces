package Twitter.model.controller

import org.unq.TwitterSystem

class TweetController() {

    lateinit var twitter : TwitterSystem
    constructor(twitter : TwitterSystem) : this() {
        this.twitter = twitter
    }


}