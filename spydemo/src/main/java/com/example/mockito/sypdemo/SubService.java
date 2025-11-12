package com.example.mockito.sypdemo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubService extends  AbstractService {
    private DependencyService dependencyService;

    @Override
    protected String additionalProcessing(String input) {
        System.out.println("SubService: Additional processing for input: " + input);
        return dependencyService.getData(input);
    }
}
