package com.example.test6;

import com.example.MyService;
import com.example.NameService;
import com.example.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MyServiceTestConfiguration6.class})
public class MyServiceTest6 {

    @MockitoSpyBean
    private UserService userService;

    @Autowired
    private NameService nameService;

    @MockitoSpyBean
    private MyService myService;

    @Test
    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(nameService.getUserName("MyId")).thenReturn("Mockito Spring");

        String testName = myService.getUserName("MyId");

        assertEquals("Mockito Spring", testName);

        verify(userService, times(1)).getUserName("MyId");

        verify(myService, times(1)).getUserInfo("MyId");

        // invoke a second time to verify cache behavior
        String cachedName = myService.getUserName("MyId");
        verify(userService, times(1)).getUserName("MyId");
    }
}