package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Mock
    private UserService userServiceMock;

    @InjectMocks
    private UserManager userManager;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUserWithValidUsername() {

        String username = "validUser";
        String password = "password123";
        when(userServiceMock.usernameExists(username)).thenReturn(false);
        when(userServiceMock.saveUser(username, password)).thenReturn(true);


        boolean result = userManager.registerUser(username, password);


        assertTrue(result);
        verify(userServiceMock).usernameExists(username);
        verify(userServiceMock).saveUser(username, password);
    }

    @Test
    void testRegisterUserWithExistingUsername() {

        String username = "existingUser";
        String password = "password123";
        when(userServiceMock.usernameExists(username)).thenReturn(true);


        boolean result = userManager.registerUser(username, password);


        assertFalse(result); // Registration should fail
        verify(userServiceMock).usernameExists(username);
        verify(userServiceMock, never()).saveUser(anyString(), anyString());
    }
}
