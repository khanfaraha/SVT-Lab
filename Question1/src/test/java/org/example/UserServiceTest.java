package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserRepository userRepositoryMock;
    private UserService userService;

    @BeforeEach
    void setup() {
        userRepositoryMock = mock(UserRepository.class); // Mock UserRepository
        userService = new UserService(userRepositoryMock); // Inject mock into UserService
    }

    @Test
    void testFindUserById() {

        int userId = 1;
        User mockUser = new User(userId, "John Doe");
        when(userRepositoryMock.findById(userId)).thenReturn(mockUser);

        User result = userService.findUserById(userId);

        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("John Doe", result.getName());

        verify(userRepositoryMock, times(1)).findById(userId);
    }
}
