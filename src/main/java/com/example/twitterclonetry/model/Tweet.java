package com.example.twitterclonetry.model;

import com.example.twitterclonetry.enums.TweetType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tweets")
@Data
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TweetType type;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @ManyToMany(mappedBy = "favoriteTweets")
    private List<User> favoritedBy;

    @ManyToMany(mappedBy = "tweets")
    private List<Feed> feeds;

    @CreatedDate
    private Date createdAt;
}
