package com.example.twitterclonetry.services;

import com.example.twitterclonetry.model.User;
import com.example.twitterclonetry.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean follow(UUID followerID, UUID followeeID) {
        log.info("validate input parameters for : {}", Thread.currentThread().getStackTrace()[1].getMethodName());
        if (followerID == null || followeeID == null) {
            log.error("Invalid input parameters for follow method"); 
            return false;
        }
        log.info("find users by id");
        User follower = userRepository.findById(followerID).orElse(null);
        User followee = userRepository.findById(followeeID).orElse(null);
        if (follower == null || followee == null) {
            log.error("User not found with id: {} or {}", followerID, followeeID); 
            return false;
        }
        log.info("add followee to follower's followees list and save it");
        follower.getFollowees().add(followee);
        userRepository.save(follower);
        log.info("User {} followed user {}", follower.getName(), followee.getName());
        return true;
    }

    @Override
    public boolean unfollow(UUID followerID, UUID followeeID) {
        log.info("validate input parameters for : {}", Thread.currentThread().getStackTrace()[1].getMethodName());
        if (followerID == null || followeeID == null) {
            log.error("Invalid input parameters for unfollow method");
            return false;
        }
        log.info("find users by id");
        User follower = userRepository.findById(followerID).orElse(null);
        User followee = userRepository.findById(followeeID).orElse(null);
        if (follower == null || followee == null) {
            log.error("User not found with id: {} or {}", followerID, followeeID);
            return false;
        }
        log.info("remove followee from follower's followees list and save it");
        follower.getFollowees().remove(followee);
        userRepository.save(follower);
        log.info("User {} unfollowed user {}", follower.getName(), followee.getName());
        return true;
    }
}
