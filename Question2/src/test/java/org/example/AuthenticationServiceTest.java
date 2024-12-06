package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginManagerTest {

    @Test
    void testLoginValidCredentials() throws Exception {
        AuthenticationService mockAuthService = Mockito.mock(AuthenticationService.class);
        LoginManager loginManager = new LoginManager(mockAuthService);

        when(mockAuthService.authenticate("validUser", "validPass")).thenReturn(true);

        assertTrue(loginManager.login("validUser", "validPass"));
        verify(mockAuthService).authenticate("validUser", "validPass");
    }

    @Test
    void testLoginInvalidCredentials() throws Exception {
        AuthenticationService mockAuthService = Mockito.mock(AuthenticationService.class);
        LoginManager loginManager = new LoginManager(mockAuthService);

        when(mockAuthService.authenticate("invalidUser", "invalidPass")).thenReturn(false);

        assertFalse(loginManager.login("invalidUser", "invalidPass"));
        verify(mockAuthService).authenticate("invalidUser", "invalidPass");
    }

    @Test
    void testLoginNullCredentialsThrowsException() {
        AuthenticationService mockAuthService = Mockito.mock(AuthenticationService.class);
        LoginManager loginManager = new LoginManager(mockAuthService);

        Exception exception = assertThrows(Exception.class, () -> loginManager.login(null, "password"));
        assertEquals("Username and password cannot be null", exception.getMessage());

        exception = assertThrows(Exception.class, () -> loginManager.login("username", null));
        assertEquals("Username and password cannot be null", exception.getMessage());
    }
}
