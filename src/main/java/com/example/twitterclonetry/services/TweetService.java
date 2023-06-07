package com.example.twitterclonetry.services;

import java.util.UUID;

public interface TweetService {
    boolean postTweet(UUID userId, String content, String mediaURL);
}
