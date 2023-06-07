package com.example.twitterclonetry.services;

import java.util.UUID;

public interface UserService {
    boolean follow(UUID followerID, UUID followeeID);

    boolean unfollow(UUID followerID, UUID followeeID);
}
