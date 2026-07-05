package jonah_rosner.auth_system.User;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = null;
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        LocalDateTime tokenExpiration = LocalDateTime.now().plusHours(1);
        LocalDateTime refreshTokenExpiration = LocalDateTime.now().plusDays(7);
        user.setTokenExpiration(tokenExpiration);
        user.setRefreshTokenExpiration(refreshTokenExpiration);
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
        if (this.userRepository != null) {
            return this.userRepository.save(user);
        }
        return user;
    }
}
