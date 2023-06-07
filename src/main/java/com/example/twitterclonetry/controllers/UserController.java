package com.example.twitterclonetry.controllers;

import com.example.twitterclonetry.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/follow")
    public ResponseEntity<Boolean> follow(@RequestParam UUID followerID, @RequestParam UUID followeeID) {
        boolean result = userService.follow(followerID, followeeID);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/unfollow")
    public ResponseEntity<Boolean> unfollow(@RequestParam UUID followerID, @RequestParam UUID followeeID) {
        boolean result = userService.unfollow(followerID, followeeID);
        return ResponseEntity.ok(result);
    }
}
