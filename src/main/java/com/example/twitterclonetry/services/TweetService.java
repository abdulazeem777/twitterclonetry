package com.example.twitterclonetry.services;



public interface TweetService {
    boolean postTweet(long userId, String content, String mediaURL);
}
