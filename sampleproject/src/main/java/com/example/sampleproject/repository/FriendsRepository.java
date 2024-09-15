package com.example.sampleproject.repository;

import com.example.sampleproject.model.Friends;
import com.example.sampleproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<Friends,Long> {

    @Query("SELECT f.friend FROM Friends f WHERE f.user.id = :userId")
    List<Users> findByUserId(@Param("userId") Long userId);

    @Query("SELECT COUNT(f) FROM Friends f WHERE f.user.id = :userId and f.friend.id = :friendId")
    Long existFriendship(@Param("userId") String userId,@Param("friendId") String friendId);
}
