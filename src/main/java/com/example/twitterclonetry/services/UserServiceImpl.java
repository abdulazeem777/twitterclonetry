package com.example.twitterclonetry.services;

import com.example.twitterclonetry.model.User;
import com.example.twitterclonetry.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean follow(long followerID, long followeeID) {
        log.info("validate input parameters for : {}", Thread.currentThread().getStackTrace()[1].getMethodName());
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
    public boolean unfollow(long followerID, long followeeID) {
        log.info("validate input parameters for : {}", Thread.currentThread().getStackTrace()[1].getMethodName());
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

    @Override
    public User addUser(User user) {
        log.info("validate input parameters for : {}", Thread.currentThread().getStackTrace()[1].getMethodName());
        if (user == null) {
            log.error("Invalid input parameter for addUser method");
            return null;
        }
        log.info("check if user already exists by email");
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            log.error("User already exists with email: {}", user.getEmail());
            return null;
        }
        log.info("save user and return it");
        userRepository.save(user);
        log.info("User added successfully with id: {}", user.getId());
        return user;
    }
}
