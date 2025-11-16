package com.example.test1;

import com.example.NameService;
import com.example.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceUnitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private NameService nameService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(nameService.getUserName("MyId")).thenReturn("Mockito Spring");

        String testName = userService.getUserName("MyId");

        Assert.assertEquals("Mockito Spring", testName);

        verify(nameService, times(1)).getUserName("MyId");
    }
}