package com.example.twitterclonetry.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Feed {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "feeds_tweets",
            joinColumns = @JoinColumn(name = "feed_id"),
            inverseJoinColumns = @JoinColumn(name = "tweet_id"))
    private List<Tweet> tweets;
}
