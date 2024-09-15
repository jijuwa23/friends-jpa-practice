package com.example.sampleproject.controller;

import com.example.sampleproject.dto.FriendRequest;
import com.example.sampleproject.model.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserAPI {

    List<Users> getUsers();

    ResponseEntity<Users> addUser(Users user);

    ResponseEntity<String> addFriend(String userId, FriendRequest friendRequest);

    List<Users> getFriends(String userId);
}
