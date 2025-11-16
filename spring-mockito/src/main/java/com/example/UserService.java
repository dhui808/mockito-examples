package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private NameService nameService;

    @Autowired
    public UserService(NameService nameService) {
        this.nameService = nameService;
    }

    @Cacheable("userIds")
    public String getUserName(String id) {
        System.out.println("Fetching user name for id: " + id);
        return nameService.getUserName(id);
    }
}
