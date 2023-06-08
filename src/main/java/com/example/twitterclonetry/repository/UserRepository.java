package com.example.twitterclonetry.repository;

import com.example.twitterclonetry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("select u.followees from User u where u.id = :userID")
    List<User> getFollowees(@Param("userID") UUID userID);

    User findByEmail(@Param("email") String email);
}
