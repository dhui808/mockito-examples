package com.example.test3;

import com.example.NameService;
import com.example.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceTestConfiguration {
    @Bean
    public NameService nameService() {
        return Mockito.mock(NameService.class);
    }

    @Bean
    public UserService userService(NameService nameService) {
        return new UserService(nameService);
    }
}
