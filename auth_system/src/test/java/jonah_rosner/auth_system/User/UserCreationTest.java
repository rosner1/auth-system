package jonah_rosner.auth_system.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class UserCreationTest {

    @Test
    void createUser_setsExpirationDatesAndReturnsTheUser() {
        UserService userService = new UserService();
        User user = new User("alice", "alice@example.com", "secret", null, null, null, null);

        LocalDateTime before = LocalDateTime.now();
        User createdUser = userService.createUser(user);
        LocalDateTime after = LocalDateTime.now();

        assertNotNull(createdUser);
        assertEquals("alice", createdUser.getUsername());
        assertEquals("alice@example.com", createdUser.getEmail());
        assertNotNull(createdUser.getTokenExpiration());
        assertNotNull(createdUser.getRefreshTokenExpiration());
        assertTrue(createdUser.getTokenExpiration().isAfter(before));
        assertTrue(createdUser.getTokenExpiration().isBefore(after.plusHours(2)));
        assertTrue(createdUser.getRefreshTokenExpiration().isAfter(before));
        assertTrue(createdUser.getRefreshTokenExpiration().isBefore(after.plusDays(8)));
    }

    @Test
    void createUser_endpointReturnsCreatedStatusAndBody() {
        UserController userController = new UserController(new UserService());
        User request = new User("bob", "bob@example.com", "password", null, null, null, null);

        ResponseEntity<User> response = userController.createUser(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("bob", response.getBody().getUsername());
        assertNotNull(response.getBody().getTokenExpiration());
        assertNotNull(response.getBody().getRefreshTokenExpiration());
    }
}
