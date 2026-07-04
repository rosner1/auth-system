package jonah_rosner.auth_system.User;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UserService {
    // Business logic

    public User createUser(User user) {
        LocalDateTime tokenExpiration = LocalDateTime.now().plusHours(1);
        LocalDateTime refreshTokenExpiration = LocalDateTime.now().plusDays(7);
        user.setTokenExpiration(tokenExpiration);
        user.setRefreshTokenExpiration(refreshTokenExpiration);
        return user;
    }
}
