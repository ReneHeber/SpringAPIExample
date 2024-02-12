package com.example.springapiexample.service;

import com.example.springapiexample.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1,"Sarah", 28, "sarah@mail.com");
        User user2 = new User(2,"Sven", 30, "sven@mail.com");
        User user3 = new User(3,"Julia", 45, "julia@mail.com");
        User user4 = new User(4,"Hanami", 32, "hanami@mail.com");
        User user5 = new User(5,"Eva", 59, "eva@mail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user: userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public Optional<List<User>> getAllUser() {
        Optional<List<User>> optional = Optional.of(userList);
        return optional;
    }
}
