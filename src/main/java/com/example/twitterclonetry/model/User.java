package com.example.twitterclonetry.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets;

    @ManyToMany
    @JoinTable(name = "favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tweet_id"))
    private List<Tweet> favoriteTweets;

    @ManyToMany
    @JoinTable(name = "followers",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "followee_id"))
    private List<User> following;

    @OneToMany(mappedBy = "user")
    private List<Feed> feeds;
}
