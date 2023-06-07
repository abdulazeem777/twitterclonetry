package com.example.twitterclonetry.controllers;

import com.example.twitterclonetry.model.Tweet;
import com.example.twitterclonetry.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @GetMapping
    public ResponseEntity<List<Tweet>> getNewsfeed(@RequestParam UUID userID) {
        List<Tweet> tweets = feedService.getNewsfeed(userID);
        return ResponseEntity.ok(tweets);
    }
}
