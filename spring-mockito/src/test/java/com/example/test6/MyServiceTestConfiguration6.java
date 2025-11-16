package com.example.test6;

import com.example.MyService;
import com.example.NameService;
import com.example.UserService;
import org.mockito.Mockito;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class MyServiceTestConfiguration6 {

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

    @Bean
    public CacheManager cacheManager() {
        return new org.springframework.cache.concurrent.ConcurrentMapCacheManager("userIds");
    }
}
