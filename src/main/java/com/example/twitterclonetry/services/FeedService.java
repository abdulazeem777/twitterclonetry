package com.example.twitterclonetry.services;

import com.example.twitterclonetry.model.Tweet;

import java.util.List;


public interface FeedService {
    List<Tweet> getNewsfeed(long userID);
}
