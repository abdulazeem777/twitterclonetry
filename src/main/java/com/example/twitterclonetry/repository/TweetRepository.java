package com.example.twitterclonetry.repository;

import com.example.twitterclonetry.model.Tweet;
import com.example.twitterclonetry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByUserIn(List<User> users);

}
