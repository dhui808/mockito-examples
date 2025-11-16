package com.example;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyService {

    private UserService userService;

    public String getUserName(String id) {
        System.out.println("MyService.getUserName called for " + id);
        return getUserInfo(id);
    }

    public String getUserInfo(String id) {
        System.out.println("MyService.getUserInfo called for " + id);
        return userService.getUserName(id);
    }
}
