package com.example.test5;

import com.example.MyService;
import com.example.NameService;
import com.example.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServiceTestConfiguration5 {

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
        return new UserService(nameService);
    }
}
