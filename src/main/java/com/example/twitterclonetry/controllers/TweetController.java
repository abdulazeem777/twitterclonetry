package com.example.twitterclonetry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @PostMapping
    public ResponseEntity<Boolean> postTweet(@RequestParam UUID userId,@RequestParam String content,
                                             @RequestParam(required = false) String mediaURL){
        boolean result = tweetService.postTweet(userID, content, mediaURL);
        return ResponseEntity.ok(result);
    }
}
