package com.example.sampleproject.service;

import com.example.sampleproject.dto.FriendRequest;
import com.example.sampleproject.model.Users;

import java.util.List;

public interface UserService {

    List<Users> getUser();

    Users addUser(Users user);

    String addFriend(String userId, FriendRequest friendRequest);

    List<Users> getFriends(String userId);
}
