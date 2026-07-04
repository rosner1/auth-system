package jonah_rosner.auth_system.User;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class User {
    // Define schema
    private UUID id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private String token;
    private String refreshToken;
    private LocalDateTime tokenExpiration;
    private LocalDateTime refreshTokenExpiration;

    public User() {
    }

    public User(String username, String email, String password,
                String token, String refreshToken, LocalDateTime tokenExpiration,
                LocalDateTime refreshTokenExpiration) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.token = token;
        this.refreshToken = refreshToken;
        this.tokenExpiration = tokenExpiration;
        this.refreshTokenExpiration = refreshTokenExpiration;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(LocalDateTime tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public LocalDateTime getRefreshTokenExpiration() {
        return refreshTokenExpiration;
    }

    public void setRefreshTokenExpiration(LocalDateTime refreshTokenExpiration) {
        this.refreshTokenExpiration = refreshTokenExpiration;
    }
}

