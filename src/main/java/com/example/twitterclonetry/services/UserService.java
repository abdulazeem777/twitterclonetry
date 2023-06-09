package com.example.twitterclonetry.services;

import com.example.twitterclonetry.model.User;



public interface UserService {
    boolean follow(long followerID, long followeeID);

    boolean unfollow(long followerID, long followeeID);

    User addUser(User user);
}
