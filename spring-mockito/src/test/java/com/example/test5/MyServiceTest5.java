package com.example.test5;

import com.example.MyService;
import com.example.NameService;
import com.example.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MyServiceTestConfiguration5.class})
public class MyServiceTest5 {

    @MockitoSpyBean
    private UserService userService;

    @Autowired
    private NameService nameService;

    @MockitoSpyBean
    private MyService myService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(userService.getUserName("MyId")).thenReturn("Mockito Spring");

        String testName = myService.getUserName("MyId");

        Assert.assertEquals("Mockito Spring", testName);

        verify(userService, times(1)).getUserName("MyId");

        verify(myService, times(1)).getUserInfo("MyId");
    }
}