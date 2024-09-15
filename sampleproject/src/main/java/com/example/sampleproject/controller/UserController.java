package com.example.sampleproject.controller;

import com.example.sampleproject.dto.FriendRequest;
import com.example.sampleproject.model.Users;
import com.example.sampleproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController implements UserAPI {

    private final UserService userService;

    @GetMapping("/users")
    @Override
    public List<Users> getUsers() {
        return userService.getUser();
    }

    @PostMapping("/users")
    @Override
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.addUser(user));
    }


    @PostMapping("/users/{userId}/friends")
    @Override
    public ResponseEntity<String> addFriend(@PathVariable("userId") String userId, @RequestBody FriendRequest friendRequest) {
        return ResponseEntity.ok(userService.addFriend(userId, friendRequest));
    }

    @GetMapping("/users/{userId}/friends")
    @Override
    public List<Users> getFriends(@PathVariable("userId") String userId) {
        return userService.getFriends(userId);
    }
}
