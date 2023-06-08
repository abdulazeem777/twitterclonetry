package com.example.twitterclonetry.services;

import com.example.twitterclonetry.model.Tweet;
import com.example.twitterclonetry.model.User;
import com.example.twitterclonetry.repository.TweetRepository;
import com.example.twitterclonetry.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class FeedServiceImpl implements FeedService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @Override
    public List<Tweet> getNewsfeed(UUID userID) {
        log.info("validate input parameters for : {}", Thread.currentThread().getStackTrace()[1].getMethodName());
        if (userID == null) {
            log.error("Invalid input parameter for getNewsfeed method"); // log error message
            return Collections.emptyList();
        }
        log.info("find user by id : {}", userID);
        User user = userRepository.findById(userID).orElse(null);
        if (user == null) {
            log.error("User not found with id: {}", userID); // log error message with parameter
            return Collections.emptyList();
        }
        log.info("get all the tweets from the user and their followees");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.addAll(user.getFollowees());
        List<Tweet> tweets = tweetRepository.findByUserIn(users);

        log.info("sort tweets by creation date in descending order and return them");
        tweets.sort(Comparator.comparing(Tweet::getCreatedAt).reversed());
        log.info("Newsfeed fetched successfully for user {}", user.getName());
        return tweets;
    }
}
