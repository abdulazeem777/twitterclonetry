package com.example.twitterclonetry.services;

import com.example.twitterclonetry.enums.TweetType;
import com.example.twitterclonetry.model.Tweet;
import com.example.twitterclonetry.model.User;
import com.example.twitterclonetry.repository.TweetRepository;
import com.example.twitterclonetry.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class TweetServiceImpl implements TweetService{

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean postTweet(UUID userID, String content, String mediaURL) {
        log.debug("Posting Tweet for user: {}", userID);
        log.info("Validating input parameters");
        if (userID == null || content == null || content.isEmpty()) {
            log.error("Empty Tweet or Null user sent from frontend :(");
            return false;
        }
        log.info("finding user by their ID:" + userID);
        User user = userRepository.findById(userID).orElse(null);
        if (user == null) {
            log.error("No user present with ID: {}", userID);
            return false;
        }
        log.info("Creating tweet entity and saving it.");
        Tweet tweet = new Tweet();
        tweet.setType(mediaURL == null ? TweetType.TEXT : TweetType.MEDIA);
        log.debug("This tweet is a : " + tweet.getType());
        if(tweet.getType() == TweetType.TEXT)
            tweet.setContent(content);
        else if(tweet.getType() == TweetType.MEDIA)
            tweet.setContent("::"+ mediaURL);
        tweet.setUser(user);
        log.info("A new tweet created and ready to be saved : {}",tweet);
        tweetRepository.save(tweet);
        return true;
    }
}
