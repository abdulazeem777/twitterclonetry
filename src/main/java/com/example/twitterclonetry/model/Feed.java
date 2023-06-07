package com.example.twitterclonetry.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany
    @JoinTable(name = "feeds_tweets",
            joinColumns = @JoinColumn(name = "feed_id"),
            inverseJoinColumns = @JoinColumn(name = "tweet_id"))
    private List<Tweet> tweets;
}
