package com.example.sampleproject.service.impl;

import com.example.sampleproject.dto.FriendRequest;
import com.example.sampleproject.model.Friends;
import com.example.sampleproject.model.Users;
import com.example.sampleproject.repository.FriendsRepository;
import com.example.sampleproject.repository.UserRepository;
import com.example.sampleproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {

    private final UserRepository userRepository;

    private final FriendsRepository friendsRepository;

    @Override
    public List<Users> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public String addFriend(String userId, FriendRequest friendRequest) {

        if (friendsRepository.existFriendship(userId, friendRequest.getFriendId()) > 0)
            throw new RuntimeException("Already Friends!");

        final Users user = userRepository.findById(Long.valueOf(userId)).orElseThrow();
        final Users friend = userRepository.findById(Long.valueOf(friendRequest.getFriendId())).orElseThrow();

        Friends friends1 = new Friends();
        friends1.setUser(user);
        friends1.setFriend(friend);

        friendsRepository.save(friends1);

        Users user2 = userRepository.findById(Long.valueOf(friendRequest.getFriendId())).orElseThrow();
        Users friend2 = userRepository.findById(Long.valueOf(userId)).orElseThrow();

        Friends friends2 = new Friends();
        friends2.setUser(user2);
        friends2.setFriend(friend2);

        friendsRepository.save(friends2);

        return "User Added!";
    }

    @Override
    public List<Users> getFriends(String userId) {
        return friendsRepository.findByUserId(Long.valueOf(userId));
    }


}
