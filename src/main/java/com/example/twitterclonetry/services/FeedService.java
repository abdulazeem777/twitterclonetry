package com.example.twitterclonetry.services;

import com.example.twitterclonetry.model.Tweet;

import java.util.List;
import java.util.UUID;

public interface FeedService {
    List<Tweet> getNewsfeed(UUID userID);
}
