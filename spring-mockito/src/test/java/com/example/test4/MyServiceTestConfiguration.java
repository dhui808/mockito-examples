package com.example.test4;

import com.example.MyService;
import com.example.NameService;
import com.example.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServiceTestConfiguration {

    @Bean
    MyService myservice(UserService userService) {
        return new MyService(userService);
    }

    @Bean
    public NameService nameService() {
        return Mockito.mock(NameService.class);
    }

    @Bean
    public UserService userService(NameService nameService) {
        return Mockito.mock(UserService.class);
    }
}
