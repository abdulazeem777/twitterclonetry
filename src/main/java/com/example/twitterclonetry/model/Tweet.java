package com.example.twitterclonetry.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tweets")
@Data
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(mappedBy = "favoriteTweets")
    private List<User> favoritedBy;

    @ManyToMany(mappedBy = "tweets")
    private List<Feed> feeds;
}
