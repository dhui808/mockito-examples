package com.example.mockito.sypdemo;

import org.springframework.stereotype.Service;

@Service
public class DependencyService {
    public String getData(String input) {
        System.out.println("DependencyService: Getting data for input: " + input);
        return "Data for " + input;
    }
}
