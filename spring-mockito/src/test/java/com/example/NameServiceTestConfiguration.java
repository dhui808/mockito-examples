package com.example;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NameServiceTestConfiguration {
    @Bean
    public NameService nameService() {
        return Mockito.mock(NameService.class);
    }
}
