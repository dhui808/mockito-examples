package com.example.mockito.sypdemo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public abstract class AbstractService {

    public String processData(String input) {

        String response = callDependency(input);
        return response;
    }

    protected String callDependency(String input) {
        System.out.println("AbstractService: Processing input: " + input);
        return additionalProcessing(input);
    }

    protected abstract String additionalProcessing(String input);
}
