package com.example.twitterclonetry.controllers;

import com.example.twitterclonetry.model.User;
import com.example.twitterclonetry.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User result = userService.addUser(user);
        return ResponseEntity.ok(result);
    }
}
