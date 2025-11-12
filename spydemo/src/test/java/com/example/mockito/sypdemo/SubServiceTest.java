package com.example.mockito.sypdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubServiceTest {

    private DependencyService dependency;
    private SubService subService;

    @BeforeEach
    void setUp() {
        dependency = mock(DependencyService.class);
        // Need to spy on SubService to verify calls to its methods
        // since the argument of verify must be a mock or a spy
        // Inject the mocked dependency into the spied SubService
        subService = Mockito.spy(new SubService(dependency));
    }

    @Test
    void testProcess_ReturnsExpectedResult() {
        when(dependency.getData(anyString())).thenReturn("mockedResult");

        String result = subService.processData("input");

        verify(dependency, times(1)).getData("input");
        verify(subService, times(1)).callDependency("input");
    }
}
